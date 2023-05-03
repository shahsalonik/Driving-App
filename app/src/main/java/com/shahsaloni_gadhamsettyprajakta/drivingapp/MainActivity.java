package com.shahsaloni_gadhamsettyprajakta.drivingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.content.Intent;

import com.shahsaloni_gadhamsettyprajakta.drivingapp.viewRenderer.AbstractViewRenderer;

import java.io.File;

public class MainActivity extends AppCompatActivity {

        RelativeLayout logScreen;
        TableLayout tableLayout;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            logScreen = findViewById(R.id.log_screen);
            tableLayout = (TableLayout) findViewById(R.id.log_table);
        }

        public void startDriving(View view) {
                Intent intent = new Intent(getApplicationContext(), Driving.class);
                startActivity(intent);
        }

        public void viewLog(View view) {
                Intent intent = new Intent(getApplicationContext(), LogFile.class);
                String extra = getIntent().getStringExtra("extra");
                System.out.println(extra);
                intent.putExtra("time", extra);
                startActivity(intent);
        }

        public void shareSheet(View view) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("application/pdf");
            startActivity(Intent.createChooser(shareIntent, null));
        }

        /*
        public void shareSheet(View view) {
            AbstractViewRenderer page = new AbstractViewRenderer(getApplicationContext(), R.layout.log) {
                private String _text;

                public void setText(String text) {
                    _text = text;
                }

                @Override
                protected void initView(View view) {
                    TextView tv_hello = (TextView) view.findViewById(R.id.tv_hello);
                    tv_hello.setText(_text);
                }
            };

            page.setReuseBitmap(true);

            PdfDocument doc = new PdfDocument(getApplicationContext());

            // add as many pages as you have
            doc.addPage(page);

            doc.setRenderWidth(2115);
            doc.setRenderHeight(1500);
            doc.setOrientation(PdfDocument.A4_MODE.LANDSCAPE);
            doc.setProgressTitle(R.string.gen_please_wait);
            doc.setProgressMessage(R.string.gen_pdf_file);
            doc.setFileName("test");
            doc.setSaveDirectory(getApplicationContext().getExternalFilesDir(null));
            doc.setInflateOnMainThread(false);
            doc.setListener(new PdfDocument.Callback() {
                @Override
                public void onComplete(File file) {
                    Log.i(PdfDocument.TAG_PDF_MY_XML, "Complete");
                }

                @Override
                public void onError(Exception e) {
                    Log.i(PdfDocument.TAG_PDF_MY_XML, "Error");
                }
            });

            doc.createPdf(getApplicationContext());

        }
        */
}