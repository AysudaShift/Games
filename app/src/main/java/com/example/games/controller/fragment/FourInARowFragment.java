package com.example.games.controller.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.games.R;

import java.awt.font.TextAttribute;
import java.security.spec.ECField;
import java.util.zip.CheckedOutputStream;

public class FourInARowFragment extends Fragment {

    public static final String TAG = "TAG";
    private TextView
            mTextView0, mTextView1, mTextView2, mTextView3, mTextView4,
            mTextView5, mTextView6, mTextView7, mTextView8, mTextView9,
            mTextView10, mTextView11, mTextView12, mTextView13, mTextView14,
            mTextView15, mTextView16, mTextView17, mTextView18, mTextView19,
            mTextView20, mTextView21, mTextView22, mTextView23, mTextView24;
    private TextView[][] mTextViewXOArray;
    private TextView mTextViewWinner;
    View.OnClickListener myListener;
    private int mGameState = 0;

    /************************ CONSTRUCTOR ***************************/
    public FourInARowFragment() {
        // Required empty public constructor
    }

    /************************** NEW INSTANCE **************************/
    public static FourInARowFragment newInstance() {
        FourInARowFragment fragment = new FourInARowFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    /************************** ON CREATE ***********************/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /************************** ON CREATE VIEW **********************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four_in_a_row, container, false);
        findViews(view);
        updateTextViewArray();
        setListenerView();
        setListener();
        return view;
    }

    /*************************** FIND VIEW **************************/
    private void findViews(View view) {
        mTextView0 = view.findViewById(R.id.rowTxt0);
        mTextView1 = view.findViewById(R.id.rowTxt1);
        mTextView2 = view.findViewById(R.id.rowTxt2);
        mTextView3 = view.findViewById(R.id.rowTxt3);
        mTextView4 = view.findViewById(R.id.rowTxt4);

        mTextView5 = view.findViewById(R.id.rowTxt5);
        mTextView6 = view.findViewById(R.id.rowTxt6);
        mTextView7 = view.findViewById(R.id.rowTxt7);
        mTextView8 = view.findViewById(R.id.rowTxt8);
        mTextView9 = view.findViewById(R.id.rowTxt9);

        mTextView10 = view.findViewById(R.id.rowTxt10);
        mTextView11 = view.findViewById(R.id.rowTxt11);
        mTextView12 = view.findViewById(R.id.rowTxt12);
        mTextView13 = view.findViewById(R.id.rowTxt13);
        mTextView14 = view.findViewById(R.id.rowTxt14);

        mTextView15 = view.findViewById(R.id.rowTxt15);
        mTextView16 = view.findViewById(R.id.rowTxt16);
        mTextView17 = view.findViewById(R.id.rowTxt17);
        mTextView18 = view.findViewById(R.id.rowTxt18);
        mTextView19 = view.findViewById(R.id.rowTxt19);

        mTextView20 = view.findViewById(R.id.rowTxt20);
        mTextView21 = view.findViewById(R.id.rowTxt21);
        mTextView22 = view.findViewById(R.id.rowTxt22);
        mTextView23 = view.findViewById(R.id.rowTxt23);
        mTextView24 = view.findViewById(R.id.rowTxt24);
    }

    /*********************** UPDATE TEXT VIEW ARRAY *****************/
    private void updateTextViewArray() {
        mTextViewXOArray = new TextView[][]{
                {mTextView0, mTextView1, mTextView2, mTextView3, mTextView4},
                {mTextView5, mTextView6, mTextView7, mTextView8, mTextView9},
                {mTextView10, mTextView11, mTextView12, mTextView13, mTextView14},
                {mTextView15, mTextView16, mTextView17, mTextView18, mTextView19},
                {mTextView20, mTextView21, mTextView22, mTextView23, mTextView24}};
    }

    /*********************** SET LISTENER VIEW ************************/
    private void setListenerView() {

        myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "mTextView0");

                switch (v.getId()) {
                    case R.id.rowTxt0:
                        //0
                        changeState(mTextView0, 0);
                        break;
                    case R.id.rowTxt1:
                        changeState(mTextView1, 1);
                        break;
                    case R.id.rowTxt2:
                        changeState(mTextView2, 2);
                        break;
                    case R.id.rowTxt3:
                        changeState(mTextView3, 3);
                        break;
                    case R.id.rowTxt4:
                        changeState(mTextView4, 4);
                        break;
                    //1
                    case R.id.rowTxt5:
                        changeState(mTextView5, 0);
                        break;
                    case R.id.rowTxt6:
                        changeState(mTextView6, 1);
                        break;
                    case R.id.rowTxt7:
                        changeState(mTextView7, 2);
                        break;
                    case R.id.rowTxt8:
                        changeState(mTextView8, 3);
                        break;

                    case R.id.rowTxt9:
                        changeState(mTextView9, 4);
                        break;
                    //2
                    case R.id.rowTxt10:
                        changeState(mTextView10, 0);
                        break;

                    case R.id.rowTxt11:
                        changeState(mTextView11, 1);
                        break;

                    case R.id.rowTxt12:
                        changeState(mTextView12, 2);
                        break;

                    case R.id.rowTxt13:
                        changeState(mTextView13, 3);
                        break;

                    case R.id.rowTxt14:
                        changeState(mTextView14, 4);
                        break;

                    //3
                    case R.id.rowTxt15:
                        changeState(mTextView15, 0);
                        break;

                    case R.id.rowTxt16:
                        changeState(mTextView16, 1);
                        break;

                    case R.id.rowTxt17:
                        changeState(mTextView17, 2);
                        break;

                    case R.id.rowTxt18:
                        changeState(mTextView18, 3);
                        break;

                    case R.id.rowTxt19:
                        changeState(mTextView19, 4);
                        break;
                    //4

                    case R.id.rowTxt20:
                        changeState(mTextView20, 0);
                        break;

                    case R.id.rowTxt21:
                        changeState(mTextView21, 1);
                        break;

                    case R.id.rowTxt22:
                        changeState(mTextView22, 2);
                        break;

                    case R.id.rowTxt23:
                        changeState(mTextView23, 3);
                        break;

                    case R.id.rowTxt24:
                        changeState(mTextView24, 4);
                        break;


                }
            }
        };
    }

    /************************* SET LISTENER *********************/
    private void setListener() {
        mTextView0.setOnClickListener(myListener);
        mTextView1.setOnClickListener(myListener);
        mTextView2.setOnClickListener(myListener);
        mTextView3.setOnClickListener(myListener);
        mTextView4.setOnClickListener(myListener);
        mTextView5.setOnClickListener(myListener);
        mTextView6.setOnClickListener(myListener);
        mTextView7.setOnClickListener(myListener);
        mTextView8.setOnClickListener(myListener);
        mTextView9.setOnClickListener(myListener);
        mTextView10.setOnClickListener(myListener);
        mTextView11.setOnClickListener(myListener);
        mTextView12.setOnClickListener(myListener);
        mTextView13.setOnClickListener(myListener);
        mTextView14.setOnClickListener(myListener);
        mTextView15.setOnClickListener(myListener);
        mTextView16.setOnClickListener(myListener);
        mTextView17.setOnClickListener(myListener);
        mTextView18.setOnClickListener(myListener);
        mTextView19.setOnClickListener(myListener);
        mTextView20.setOnClickListener(myListener);
        mTextView21.setOnClickListener(myListener);
        mTextView22.setOnClickListener(myListener);
        mTextView23.setOnClickListener(myListener);
        mTextView24.setOnClickListener(myListener);
    }

    /********************* CHANGE STATE ***************************/
    public void changeState(TextView textView, int j) {
        if (getColorId(textView) == Color.BLACK && !isHaveWinner()) {
            int fitRow = getFitRow(j);
            if (fitRow == -1)
                Toast.makeText(getActivity(), "this column is full", Toast.LENGTH_LONG).show();
            else {

                mTextViewXOArray[fitRow][j].setBackgroundColor(Color.RED);
                mGameState++;
                randomPlay();
            }


        } else if (isHaveWinner()) {
            makeToast();

        } else if (!isHaveWinner() && mGameState == 25) {
            generateToast(R.string.toast_draw);
        }

    }

    /*********************** MAKE TOAST *****************************/
    private void makeToast() {
        switch (getColorId(mTextViewWinner)) {

            case Color.BLUE:

                generateToast(R.string.toast_android_won);
                break;
            case Color.RED:
                generateToast(R.string.toast_you_won);

        }
    }

    /************************* GENERATE TOAST *********************/
    private void generateToast(int messageResId) {

        Toast.makeText(getActivity(), messageResId, Toast.LENGTH_LONG)
                .show();


    }

    /************************ RANDOM PLAY ***************************/
    private void randomPlay() {
        if (!isHaveWinner() && mGameState < 25) {

            int randomColumn = generateRandomColumn();
            while (getFitRow(randomColumn) == -1) {
                randomColumn = generateRandomColumn();
            }
            int randomFitRow = getFitRow(randomColumn);
            mTextViewXOArray[randomFitRow][randomColumn].setBackgroundColor(Color.BLUE);
            mGameState++;
        }
    }

    /**************************** IS HAVE WINNER *************************/
    public boolean isHaveWinner() {
        for (int k = 0; k < 5; k++) {
            if (isWinDiagonal(k)) {
                return true;

            }
            for (int l = 0; l < 5; l++) {
                if (isWinRow(k, l)) {
                    return true;
                }
                if (isWinColumn(k, l)) {
                    return true;
                }

            }
        }
        return false;

    }

    /***************** IS WIN DIAGONAL *******************/
    public boolean isWinDiagonal(int i) {
        switch (i) {
            case 0:
                if (getColorId(mTextViewXOArray[1][1]) != Color.BLACK &&
                        getColorId(mTextViewXOArray[1][1]) == getColorId(mTextViewXOArray[2][2]) &&
                        getColorId(mTextViewXOArray[1][1]) == getColorId(mTextViewXOArray[3][3]) &&
                        (getColorId(mTextViewXOArray[1][1]) == getColorId(mTextViewXOArray[0][0]) ||
                                getColorId(mTextViewXOArray[1][1]) == getColorId(mTextViewXOArray[4][4])
                        )) {
                    mTextViewWinner = mTextViewXOArray[1][1];
                    return true;
                }

                if (getColorId(mTextViewXOArray[0][1]) != Color.BLACK &&
                        getColorId(mTextViewXOArray[0][1]) == getColorId(mTextViewXOArray[1][2]) &&
                        getColorId(mTextViewXOArray[0][1]) == getColorId(mTextViewXOArray[2][3]) &&
                        getColorId(mTextViewXOArray[0][1]) == getColorId(mTextViewXOArray[3][4])
                ) {
                    mTextViewWinner = mTextViewXOArray[0][1];
                    return true;
                }

                if (getColorId(mTextViewXOArray[0][3]) != Color.BLACK &&
                        getColorId(mTextViewXOArray[0][3]) == getColorId(mTextViewXOArray[1][2]) &&
                        getColorId(mTextViewXOArray[0][3]) == getColorId(mTextViewXOArray[2][1]) &&
                        getColorId(mTextViewXOArray[0][3]) == getColorId(mTextViewXOArray[3][0])
                ) {
                    mTextViewWinner = mTextViewXOArray[0][3];
                    return true;
                }

                if (getColorId(mTextViewXOArray[1][3]) != Color.BLACK &&
                        getColorId(mTextViewXOArray[1][3]) == getColorId(mTextViewXOArray[2][2]) &&
                        getColorId(mTextViewXOArray[1][3]) == getColorId(mTextViewXOArray[3][1]) &&
                        (getColorId(mTextViewXOArray[1][3]) == getColorId(mTextViewXOArray[4][0])
                                || getColorId(mTextViewXOArray[1][3]) == getColorId(mTextViewXOArray[0][4]))
                ) {
                    mTextViewWinner = mTextViewXOArray[1][3];
                    return true;
                }
                break;

            case 1:
                if (getColorId(mTextViewXOArray[1][0]) != Color.BLACK &&
                        getColorId(mTextViewXOArray[1][0]) == getColorId(mTextViewXOArray[2][1]) &&
                        getColorId(mTextViewXOArray[1][0]) == getColorId(mTextViewXOArray[3][2]) &&
                        getColorId(mTextViewXOArray[1][0]) == getColorId(mTextViewXOArray[4][3])) {
                    mTextViewWinner = mTextViewXOArray[1][0];
                    return true;
                }

                if (getColorId(mTextViewXOArray[1][4]) != Color.BLACK &&
                        getColorId(mTextViewXOArray[1][4]) == getColorId(mTextViewXOArray[2][3]) &&
                        getColorId(mTextViewXOArray[1][4]) == getColorId(mTextViewXOArray[3][2]) &&
                        getColorId(mTextViewXOArray[1][4]) == getColorId(mTextViewXOArray[4][1])) {
                    mTextViewWinner = mTextViewXOArray[1][4];
                    return true;
                }
                break;
        }
        return false;
    }

    /****************** IS WIN ROW ***************/
    public boolean isWinRow(int i, int j) {
        if ((j == 0 || j == 1)
                &&
                getColorId(mTextViewXOArray[i][j + 1]) != Color.BLACK
                &&
                getColorId(mTextViewXOArray[i][j + 1]) == getColorId(mTextViewXOArray[i][j + 2])
                &&
                getColorId(mTextViewXOArray[i][j + 1]) == getColorId(mTextViewXOArray[i][j + 3])
                &&
                (getColorId(mTextViewXOArray[i][j + 1]) == getColorId(mTextViewXOArray[i][j])
                        ||

                        (j == 0 && getColorId(mTextViewXOArray[i][j + 1]) ==
                                getColorId(mTextViewXOArray[i][j + 4])))) {
            mTextViewWinner = mTextViewXOArray[i][j + 1];
            return true;
        }
        return false;
    }

    /************* IS WIN COLUMN **************/
    public boolean isWinColumn(int i, int j) {
        if ((i == 0 || i == 1) &&
                getColorId(mTextViewXOArray[i + 1][j]) != Color.BLACK &&
                getColorId(mTextViewXOArray[i + 1][j]) == getColorId(mTextViewXOArray[i + 2][j])
                &&
                getColorId(mTextViewXOArray[i + 1][j]) == getColorId(mTextViewXOArray[i + 3][j])
                &&
                (getColorId(mTextViewXOArray[i + 1][j]) == getColorId(mTextViewXOArray[i][j])
                        ||

                        (i == 0 && getColorId(mTextViewXOArray[i + 1][j]) ==
                                getColorId(mTextViewXOArray[i + 4][j])))) {
            mTextViewWinner = mTextViewXOArray[i + 1][j];
            return true;
        }
        return false;
    }

    /********************************* GET FIT ROW ***************************/
    private int getFitRow(int j) {
        for (int k = 4; k >= 0; --k) {
            Log.d(TAG, String.valueOf(k));
            int colorId = getColorId(mTextViewXOArray[k][j]);
            if (colorId == Color.BLACK) {
                return k;
            }
        }
        return -1;
    }

    /******************** GET COLOR ID ************************/
    private int getColorId(TextView textView1) {
        ColorDrawable viewColor = (ColorDrawable) textView1.getBackground();
        return viewColor.getColor();
    }

    /********************* GENERATE RANDOM INDEX ***************/
    public int generateRandomColumn() {

        return (int) (Math.random() * 5);
    }


}