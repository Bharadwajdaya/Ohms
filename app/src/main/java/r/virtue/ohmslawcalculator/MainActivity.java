package r.virtue.ohmslawcalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText volts;
    EditText amps;
    EditText ohms;
    EditText watts;
    Button calculate;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volts=(EditText)findViewById(R.id.volts_num);
        amps=(EditText)findViewById(R.id.amps_num);
        ohms=(EditText)findViewById(R.id.ohms_num);
        watts=(EditText)findViewById(R.id.watt_num);

        calculate=(Button)findViewById(R.id.calculate);
        reset=(Button)findViewById(R.id.Reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Write your message here.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();



                watts.setText("");
                ohms.setText("");
                amps.setText("");
                volts.setText("");
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String volt_num=volts.getText().toString();
                String amps_num=amps.getText().toString();
                String ohms_num=ohms.getText().toString();
                String watt_num=watts.getText().toString();

                if(checknotnull(watt_num,volt_num))
                {
                    System.out.println("watt_num "+watt_num+" volt_num "+volt_num);
                    double volt_num_lo=0L;
                    double ohms_num_lo=0L;
                    double watt_num_lo=0L;
                    double amps_num_lo=0L;

                    if(Double.valueOf(ohms_num)!=null)
                    {
                        ohms_num_lo=Double.valueOf(ohms_num);
                    }
                    if(Double.valueOf(amps_num)!=null)
                    {
                        amps_num_lo=Double.valueOf(amps_num);
                    }

                    volt_num_lo=amps_num_lo*ohms_num_lo;
                    watt_num_lo=volt_num_lo*amps_num_lo;
                    volts.setText(volt_num_lo+"");
                    watts.setText(watt_num_lo+"");
                }
                else if(checknotnull(watt_num,amps_num))
                {
                    double volt_num_lo=0L;
                    double ohms_num_lo=0L;
                    double watt_num_lo=0L;
                    double amps_num_lo=0L;
                    if(Double.valueOf(ohms_num)!=null)
                    {
                        ohms_num_lo=Double.valueOf(ohms_num);
                    }

                    if(Double.valueOf(volt_num)!=null)
                    {
                        volt_num_lo=Double.valueOf(volt_num);
                    }

                    amps_num_lo=volt_num_lo/ohms_num_lo;
                    watt_num_lo=volt_num_lo*amps_num_lo;
                    amps.setText(amps_num_lo+"");
                    watts.setText(watt_num_lo+"");
                }
                else if(checknotnull(ohms_num,watt_num))
                {
                    double volt_num_lo=0L;
                    double ohms_num_lo=0L;
                    double watt_num_lo=0L;
                    double amps_num_lo=0L;


                    if(Double.valueOf(volt_num)!=null)
                    {
                        volt_num_lo=Double.valueOf(volt_num);
                    }
                    if(Double.valueOf(amps_num)!=null)
                    {
                        amps_num_lo=Double.valueOf(amps_num);
                    }

                    ohms_num_lo=volt_num_lo/amps_num_lo;
                    watt_num_lo=volt_num_lo*amps_num_lo;
                    ohms.setText(ohms_num_lo+"");
                    watts.setText(watt_num_lo+"");
                }
                else if(checknotnull(ohms_num,amps_num))
                {
                    double volt_num_lo=0L;
                    double ohms_num_lo=0L;
                    double watt_num_lo=0L;
                    double amps_num_lo=0L;
                    if(Double.valueOf(watt_num)!=null)
                    {
                        watt_num_lo=Double.valueOf(watt_num);
                    }
                    if(Double.valueOf(volt_num)!=null)
                    {
                        volt_num_lo=Double.valueOf(volt_num);
                    }

                    amps_num_lo=watt_num_lo/volt_num_lo;
                    ohms_num_lo=volt_num_lo/amps_num_lo;
                    amps.setText(amps_num_lo+"");
                    ohms.setText(ohms_num_lo+"");
                }
                else if(checknotnull(ohms_num,volt_num))
                {
                    double volt_num_lo=0L;
                    double ohms_num_lo=0L;
                    double watt_num_lo=0L;
                    double amps_num_lo=0L;
                    if(Double.valueOf(watt_num)!=null)
                    {
                        watt_num_lo=Double.valueOf(watt_num);
                    }
                    if(Double.valueOf(amps_num)!=null)
                    {
                        amps_num_lo=Double.valueOf(amps_num);
                    }

                    volt_num_lo=watt_num_lo/amps_num_lo;
                    ohms_num_lo=volt_num_lo/amps_num_lo;
                    volts.setText(volt_num_lo+"");
                    ohms.setText(ohms_num_lo+"");
                }
                else if(checknotnull(amps_num,volt_num))
                {
                    double volt_num_lo=0L;
                    double ohms_num_lo=0L;
                    double watt_num_lo=0L;
                    double amps_num_lo=0L;

                    if(Double.valueOf(watt_num)!=null)
                    {
                        watt_num_lo=Double.valueOf(watt_num);
                    }
                    if(Double.valueOf(ohms_num)!=null)
                    {
                        ohms_num_lo=Double.valueOf(ohms_num);
                    }

                    volt_num_lo=Math.sqrt(watt_num_lo*ohms_num_lo);
                    amps_num_lo=volt_num_lo/ohms_num_lo;
                    volts.setText(volt_num_lo+"");
                    amps.setText(amps_num_lo+"");
                }
            }
        });
    }
    boolean checknotnull(String str_one,String str_two)
    {
        System.out.println("str_one "+str_one+" str_two "+str_two);
        if(str_one.equals("") && str_two.equals("")) {
            return true;
        }
        return false;
    }
}
