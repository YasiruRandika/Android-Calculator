package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.text.Format;

public class MainActivity extends AppCompatActivity {
    Button bnDot,bnClear, bn1, bn2, bn3, bn4, bn5, bn6, bn7, bn8, bn9, bn0, bnPlus, bnMinus, bnEqual, bnDivison, bnMulti, bnPercen, bnBracket;
    TextView allInputs, answer;
    String process;
    boolean checkBracket = true;
    boolean operatorOk = false;
    boolean operatorBlock = true;
    boolean bracketBlock = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn0 = findViewById(R.id.bn_zero);
        bn1 = findViewById(R.id.bn_one);
        bn2 = findViewById(R.id.bn_two);
        bn3 = findViewById(R.id.bn_three);
        bn4 = findViewById(R.id.bn_four);
        bn5 = findViewById(R.id.bn_five);
        bn6 = findViewById(R.id.bn_six);
        bn7 = findViewById(R.id.bn_seven);
        bn8 = findViewById(R.id.bn_eight);
        bn9 = findViewById(R.id.bn_nine);

        bnEqual = findViewById(R.id.bn_equal);
        bnMinus = findViewById(R.id.bn_minus);
        bnPlus = findViewById(R.id.bn_plus);
        bnMulti = findViewById(R.id.bn_multiplication);
        bnDivison = findViewById(R.id.bn_division);
        bnClear = findViewById(R.id.bn_clear);
        bnBracket = findViewById(R.id.bn_bracket);
        bnDot = findViewById(R.id.bn_dot);
        bnPercen = findViewById(R.id.bn_percentage);

        allInputs = findViewById(R.id.inputs);
        answer = findViewById(R.id.output);

        bnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allInputs.setText("");
                answer.setText("");
                checkBracket = true;
                operatorBlock = true;
                bracketBlock = true;
            }
        });

        bn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 0);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 1);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 2);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 3);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 4);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 5);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 6);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 7);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 8);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                allInputs.setText(process + 9);
                operatorOk = true;
                operatorBlock = false;
                calculate();
                bracketBlock = false;
            }
        });

        bnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                if (operatorBlock) {
                    return;
                } else if(operatorOk) {
                    allInputs.setText(process + "+");
                } else {
                    int len = process.length();
                    process = process.substring(0,len-1);
                    allInputs.setText(process + "+");
                }
                operatorOk = false;
                operatorBlock = false;
                bracketBlock = true;
            }
        });

        bnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                if (operatorBlock) {
                    return;
                } else if(operatorOk) {
                    allInputs.setText(process + "-");
                } else {
                    int len = process.length();
                    process = process.substring(0,len-1);
                    allInputs.setText(process + "-");
                }
                operatorOk = false;
                operatorBlock = false;
                bracketBlock = true;

            }
        });

        bnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                if (operatorBlock) {
                    return;
                } else if(operatorOk) {
                    allInputs.setText(process + "x");
                } else {
                    int len = process.length();
                    process = process.substring(0,len-1);
                    allInputs.setText(process + "x");
                }
                operatorOk = false;
                operatorBlock = false;
                bracketBlock = true;
            }
        });

        bnDivison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                if (operatorBlock) {
                    return;
                } else if(operatorOk) {
                    allInputs.setText(process + "÷");
                } else {
                    int len = process.length();
                    process = process.substring(0,len-1);
                    allInputs.setText(process + "÷");
                }
                operatorOk = false;
                operatorBlock = false;
                bracketBlock = true;
            }
        });

        bnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                if(operatorOk) {
                    allInputs.setText(process + ".");
                } else {
                    return;
                }

                operatorOk = false;
                operatorBlock = true;
                bracketBlock = true;
            }
        });

        bnPercen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = allInputs.getText().toString();
                int len = process.length();
                if (len == 2) {
                    allInputs.setText(process.substring(0,1));
                    answer.setText(process.substring(0,1));
                    if (process.charAt(0) == '(') {
                        checkBracket = true;
                        bracketBlock = false;
                        operatorBlock = false;
                        operatorOk = false;
                        answer.setText("");
                    }
                } else if (len <= 1) {
                    allInputs.setText("");
                    answer.setText("");
                    checkBracket = true;
                    operatorBlock = true;
                    bracketBlock = true;
                } else {
                    allInputs.setText(process.substring(0, process.length() - 1));
                    process = allInputs.getText().toString();
                    len = process.length();
                    if (process.charAt(len - 1) == '+' || process.charAt(len - 1) == '÷' || process.charAt(len - 1) == 'x' || process.charAt(len - 1) == '-') {
                        operatorOk = false;
                        operatorBlock = false;
                        bracketBlock = true;
                        answer.setText("");
                    } else if (process.charAt(len - 1) == ')') {
                        checkBracket = false;
                        bracketBlock = false;
                        operatorBlock = false;
                        operatorOk = true;
                        calculate();
                    } else if (process.charAt(len - 1) == '(') {
                        checkBracket = true;
                        bracketBlock = false;
                        operatorBlock = false;
                        operatorOk = false;
                        answer.setText("");
                    } else {
                        operatorOk = true;
                        operatorBlock = false;
                        answer.setText("");
                        calculate();
                        bracketBlock = false;
                    }
                }
            }
        });

        bnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bracketBlock == false && checkBracket == false) {
                    process = allInputs.getText().toString();
                    allInputs.setText(process + ")");
                    checkBracket = true;
                    operatorBlock = false;
                }else if (checkBracket == true && bracketBlock == true) {
                    process = allInputs.getText().toString();
                    allInputs.setText(process + "(");
                    checkBracket = false;
                    operatorBlock = true;
                } else {
                    return;
                }
            }
        });

        bnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

    }

    public void calculate() {
        if (checkBracket == false) {
            return;
        }
        process = allInputs.getText().toString();

        process = process.replaceAll("÷", "/");
        process = process.replaceAll("x", "*");
        process = process.replaceAll("%","/100");

        Context rahino = Context.enter();
        rahino.setOptimizationLevel(-1);

        String finalResult = "";

        try {
            Scriptable scriptable = rahino.initStandardObjects();
            finalResult = rahino.evaluateString(scriptable,process,"javascript",1,null).toString();

            float finalFloat = Float.parseFloat(finalResult);
            finalResult = String.format("%.3f", finalFloat);


        } catch (Exception e) {
            finalResult = "0";
        }

        int len = finalResult.length();

        if (finalResult.charAt(len-3) == '0' && finalResult.charAt(len-2) == '0' && finalResult.charAt(len-1) == '0'){
            finalResult = finalResult.substring(0, finalResult.length() - 4);
        }

        answer.setText(finalResult);
    }
}
