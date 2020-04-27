package com.example.project_capstone;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateNewBatchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView mDateDisplay;
    private TextView mTimeDisplay;
    private TextView mSelectReportTo;
    private TextView mSelectPackage;
    private TextView mSelectFlag;
    private TextView mDueDate;
    private EditText mReceivedBy;
    private EditText mBatchName;
    private EditText mCOCNumber;
    private EditText mClientName;
    private EditText mSampleType;
    private EditText mPrepCode;
    private TextView mNoOfSamples;
    private EditText mNoOfContainers;
    private EditText mSpecialInstructions;
    private EditText mShipperReference;
    private Spinner mSite;
    private Spinner mPOSpinner;
    private Spinner mProjectSpinner;
    private Spinner mQuoteSpinner;
    private Spinner mSubmittedBySpinner;
    private Spinner mInvoiceToSpinner;
    private Spinner mStatusSpinner;
    private Spinner mShipperStatus;
    private Button mCreate;

    String[] listItems;
    boolean[] checkedItems;
    String[] packageListItems;
    boolean[] checkedPackageItems;
    String[] flagListItems;
    boolean[] checkedFlagItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    ArrayList<Integer> mPackageItems = new ArrayList<>();
    ArrayList<Integer> mFlagItems = new ArrayList<>();
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private TimePickerDialog.OnTimeSetListener mOnTimeSetListener;
    private DatePickerDialog.OnDateSetListener mOnDueDateSetListener;

    private static final String TAG = "CreateNewBatchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_batch);

        mDateDisplay = (TextView) findViewById(R.id.selectDateText);
        mTimeDisplay = (TextView) findViewById(R.id.selectTimeText);
        mSelectReportTo = (TextView) findViewById(R.id.textSelectReportTo);
        mSelectPackage = (TextView) findViewById(R.id.textSelectPackage);
        mSelectFlag = (TextView) findViewById(R.id.textSelectFlag);
        mDueDate = (TextView) findViewById(R.id.dueDate);
        mCreate = (Button) findViewById(R.id.btnCreateNewBatch);
        mReceivedBy = (EditText) findViewById(R.id.editTextReceivedBy);
        mBatchName = (EditText) findViewById(R.id.editTextBatchName);
        mCOCNumber = (EditText) findViewById(R.id.editTextCOC);
        mClientName = (EditText) findViewById(R.id.editTextClient);
        mSampleType = (EditText) findViewById(R.id.editTextSampleType);
        mPrepCode = (EditText) findViewById(R.id.editTextPrepCode);
        mNoOfSamples = (EditText) findViewById(R.id.editTextNoOfSamples);
        mNoOfContainers = (EditText) findViewById(R.id.editTextContainers);
        mSpecialInstructions = (EditText) findViewById(R.id.editTextSpecialInstructions);
        mShipperReference = (EditText) findViewById(R.id.editTextShipperReference);
        mSite = (Spinner) findViewById(R.id.SiteSpinner);
        mPOSpinner = (Spinner) findViewById(R.id.POSpinner);
        mProjectSpinner = (Spinner) findViewById(R.id.ProjectSpinner);
        mQuoteSpinner = (Spinner) findViewById(R.id.QuoteSpinner);
        mSubmittedBySpinner = (Spinner) findViewById(R.id.SubmittedBySpinner);
        mInvoiceToSpinner = (Spinner) findViewById(R.id.InvoiceToSpinner);
        mStatusSpinner = (Spinner) findViewById(R.id.StatusSpinner);
        mShipperStatus = (Spinner) findViewById(R.id.ShipperStatus);

        //For Date
        mDateDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int date = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CreateNewBatchActivity.this,
                        R.style.Theme_AppCompat_Dialog,
                        mOnDateSetListener,
                        year, month, date);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        //For Date
        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String date = year + "/" + month + "/" + dayOfMonth;
                mDateDisplay.setText(date);
            }
        };

        //For Time
        mTimeDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        CreateNewBatchActivity.this,
                        R.style.Theme_AppCompat_Light_Dialog,
                        mOnTimeSetListener,
                        hour,minute,false);

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.show();
            }
        });

        //For time
        mOnTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = hourOfDay + ":" + minute;
                mTimeDisplay.setText(time);
            }
        };

        //For Report To
        listItems = getResources().getStringArray(R.array.reportTo_values);
        checkedItems = new boolean[listItems.length];

        mSelectReportTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateNewBatchActivity.this);
                mBuilder.setTitle("Select Name:");
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
//                        if (isChecked) {
//                            if (!mUserItems.contains(position)) {
//                                mUserItems.add(position);
//                            }
//                        } else if (mUserItems.contains(position)) {
//                            mUserItems.remove(position);
//                        }
                        if(isChecked){
                            mUserItems.add(position);
                        }else{
                            mUserItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems.size(); i++) {
                            item = item + listItems[mUserItems.get(i)];
                            if (i != mUserItems.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        mSelectReportTo.setText(item);
                    }
                });


                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            mUserItems.clear();

                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        //For Package
        packageListItems = getResources().getStringArray(R.array.package_values);
        checkedPackageItems = new boolean[packageListItems.length];

        mSelectPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateNewBatchActivity.this);
                mBuilder.setTitle("Select Package:");
                mBuilder.setMultiChoiceItems(packageListItems, checkedPackageItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            if (!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            }
                        } else if (mUserItems.contains(position)) {
                            mUserItems.remove(position);
                        }
                        if(isChecked){
                            mPackageItems.add(position);
                        }else{
                            mPackageItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mPackageItems.size(); i++) {
                            item = item + packageListItems[mPackageItems.get(i)];
                            if (i != mPackageItems.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        mSelectPackage.setText(item);
                    }
                });


                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedPackageItems.length; i++) {
                            checkedPackageItems[i] = false;
                            mPackageItems.clear();

                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        //For flag
        flagListItems = getResources().getStringArray(R.array.flag_values);
        checkedFlagItems = new boolean[packageListItems.length];

        mSelectFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateNewBatchActivity.this);
                mBuilder.setTitle("Select Flag:");
                mBuilder.setMultiChoiceItems(flagListItems, checkedFlagItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            if (!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            }
                        } else if (mUserItems.contains(position)) {
                            mUserItems.remove(position);
                        }
                        if(isChecked){
                            mFlagItems.add(position);
                        }else{
                            mFlagItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mFlagItems.size(); i++) {
                            item = item + flagListItems[mFlagItems.get(i)];
                            if (i != mFlagItems.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        mSelectFlag.setText(item);
                    }
                });


                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedFlagItems.length; i++) {
                            checkedFlagItems[i] = false;
                            mPackageItems.clear();

                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        //For Due Date
        mDueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int date = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CreateNewBatchActivity.this,
                        R.style.Theme_AppCompat_Dialog,
                        mOnDueDateSetListener,
                        year, month, date);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        //For Date
        mOnDueDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String date = year + "/" + month + "/" + dayOfMonth;
                mDueDate.setText(date);
            }
        };

        //OnClick
       mCreate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SampleBatch batch = new SampleBatch();
               batch.setReceivedBy(mReceivedBy.getText().toString());
               batch.setBatchName(mBatchName.getText().toString());
               batch.setCocNumber(mCOCNumber.getText().toString());
               batch.setClientName(mClientName.getText().toString());
               batch.setDateReceived(mDateDisplay.getText().toString());
               batch.setTimeReceived(mTimeDisplay.getText().toString());
               batch.setSampleType(mSampleType.getText().toString());
               batch.setPrepCode(mPrepCode.getText().toString());
               batch.setNoOfSamples(mNoOfSamples.getText().toString());
               batch.setContainers(mNoOfContainers.getText().toString());
               batch.setSpecialInstructions(mSpecialInstructions.getText().toString());
               batch.setReportTo(mSelectReportTo.getText().toString());
               batch.setAddPackage(mSelectPackage.getText().toString());
               batch.setAddFlag(mSelectFlag.getText().toString());
               batch.setDueDate(mDueDate.getText().toString());
               batch.setShipperReference(mShipperReference.getText().toString());

               Gson gson = new Gson();
               String json = gson.toJson(batch);
               Log.d(TAG,"JSON Batch:" + json);
               //Toast.makeText(CreateNewBatchActivity.this, "JSON Batch:" + json,Toast.LENGTH_SHORT).show();


           }
       });
        //For site
        ArrayAdapter<CharSequence> siteDataAdapter = ArrayAdapter.createFromResource(this, R.array.city_values, android.R.layout.simple_spinner_item);
        siteDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSite.setAdapter(siteDataAdapter);
        mSite.setOnItemSelectedListener(this);

        //For PO
        ArrayAdapter<CharSequence> poDataAdapter = ArrayAdapter.createFromResource(this, R.array.po_values, android.R.layout.simple_spinner_item);
        poDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPOSpinner.setAdapter(poDataAdapter);
        mPOSpinner.setOnItemSelectedListener(this);

        //For Project
        ArrayAdapter<CharSequence> projectDataAdapter = ArrayAdapter.createFromResource(this, R.array.project_values, android.R.layout.simple_spinner_item);
        projectDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mProjectSpinner.setAdapter(projectDataAdapter);
        mProjectSpinner.setOnItemSelectedListener(this);

        //For Quote
        ArrayAdapter<CharSequence> quoteDataAdapter = ArrayAdapter.createFromResource(this, R.array.quote_values, android.R.layout.simple_spinner_item);
        quoteDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mQuoteSpinner.setAdapter(quoteDataAdapter);
        mQuoteSpinner.setOnItemSelectedListener(this);

        //For SubmittedBy
        ArrayAdapter<CharSequence> submittedByDataAdapter = ArrayAdapter.createFromResource(this, R.array.submit_values, android.R.layout.simple_spinner_item);
        submittedByDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSubmittedBySpinner.setAdapter(submittedByDataAdapter);
        mSubmittedBySpinner.setOnItemSelectedListener(this);

        //For Invoice To
        ArrayAdapter<CharSequence> invoiceToDataAdapter = ArrayAdapter.createFromResource(this, R.array.invoice_values, android.R.layout.simple_spinner_item);
        invoiceToDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mInvoiceToSpinner.setAdapter(invoiceToDataAdapter);
        mInvoiceToSpinner.setOnItemSelectedListener(this);

        //For Status
        ArrayAdapter<CharSequence> statusDataAdapter = ArrayAdapter.createFromResource(this, R.array.status_values, android.R.layout.simple_spinner_item);
        statusDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mStatusSpinner.setAdapter(statusDataAdapter);
        mStatusSpinner.setOnItemSelectedListener(this);

        //For Shipper status
        ArrayAdapter<CharSequence> shipperStatusDataAdapter = ArrayAdapter.createFromResource(this, R.array.shipper_status_values, android.R.layout.simple_spinner_item);
        shipperStatusDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mShipperStatus.setAdapter(shipperStatusDataAdapter);
        mShipperStatus.setOnItemSelectedListener(this);



    }//OnCreate ends

    //Site

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using
         //parent.getItemAtPosition(position);
        //Log.d(TAG,parent.getItemAtPosition(position).toString() + parent);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
