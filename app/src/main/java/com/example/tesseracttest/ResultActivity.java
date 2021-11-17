package com.example.tesseracttest;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.googlecode.tesseract.android.TessBaseAPI;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ResultActivity extends AppCompatActivity {

    private Button page_back;
    private String datapath = "";
    private String lang = "";
    private ImageView test;

    static TessBaseAPI sTess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        page_back = (Button)findViewById(R.id.scan_next);
        page_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivityForResult(intent, 1001);
            }
        });
        Intent myIntent = getIntent();
        test = (ImageView) findViewById(R.id.scan_test);
        test.setImageBitmap((Bitmap)myIntent.getParcelableExtra("Captured"));

        sTess = new TessBaseAPI();
        test = (ImageView) findViewById((R.id.scan_test));
        // Tesseract 인식 언어를 한국어로 설정 및 초기화
                lang = "kor";
        datapath = getFilesDir()+ "/tesseract/";

        if(checkFile(new File(datapath+"/tessdata"))) {
            sTess.init(datapath, lang);
        };
        processImage((Bitmap)myIntent.getParcelableExtra("Captured"));
    }

    boolean checkFile(File dir)
    {
        //디렉토리가 없으면 디렉토리를 만들고 그후에 파일을 카피
        if(!dir.exists() && dir.mkdirs()) {
            copyFiles();
        }
        //디렉토리가 있지만 파일이 없으면 파일카피 진행
        if(dir.exists()) {
            String datafilepath = datapath + "/tessdata/" + lang + ".traineddata";
            File datafile = new File(datafilepath);
            if(!datafile.exists()) {
                copyFiles();
            }
        }
        return true;
    }

    void copyFiles()
    {
        AssetManager assetMgr = this.getAssets();

        InputStream is = null;
        OutputStream os = null;

        try {
            is = assetMgr.open("tessdata/"+lang+".traineddata");

            String destFile = datapath + "/tessdata/" + lang + ".traineddata";

            os = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = is.read(buffer)) != -1) {
                os.write(buffer, 0, read);
            }
            is.close();
            os.flush();
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    public String ocr(){
        OCRresult = sTess.getUTF8Text();
        return OCRresult;
    }
     */

    public void processImage(Bitmap bitmap){
        String OCRresult = "";
        sTess.setImage(bitmap);
        OCRresult = sTess.getUTF8Text();
        TextView textResult = (TextView) findViewById(R.id.ocr_Result);
        textResult.setText(OCRresult);
        if(OCRresult == ""){
            textResult.setText("문자가 인식 되지 않았습니다. 다시 촬영해 주세요.");
        }
    }
}

