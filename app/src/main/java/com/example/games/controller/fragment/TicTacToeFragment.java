package com.example.games.controller.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.games.R;

import java.lang.ref.SoftReference;

public class TicTacToeFragment extends Fragment {
    public static final String TAG = "TAG";


    private TextView mTextView0, mTextView1, mTextView2, mTextView3, mTextView4,
            mTextView5, mTextView6, mTextView7, mTextView8;
    private TextView[][] mTextViewXOArray;
    private TextView mTextViewWinner;
    private  int mGameState=0;
    private TextView mTextViewXWins;
    private TextView mTextViewOWins;
    private TextView mTextViewDraw;
    private int mXWins=0;
    private int mOWins=0;
    private int mDraw=0;

    View.OnClickListener myListner;

    /************************ CONSTRUCTOR *******************/
    public TicTacToeFragment() {
        // Required empty public constructor
    }

    /************************* NEW INSTANCE **************/
    public static TicTacToeFragment newInstance() {
        TicTacToeFragment fragment = new TicTacToeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /******************** ON CREATE **********************/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /***************** ON CREATE VIEW ******************/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
        findViews(view);
        updateTextViewArray();
        setListenerView();
        setListener();


        return view;
    }
    /******************** FIND VIEWS *********************/
    private void findViews(View view) {
        mTextView0 = view.findViewById(R.id.txtView_0);
        mTextView1 = view.findViewById(R.id.txtView_1);
        mTextView2 = view.findViewById(R.id.txtView_2);

        mTextView3 = view.findViewById(R.id.txtView_3);
        mTextView4 = view.findViewById(R.id.txtView_4);
        mTextView5 = view.findViewById(R.id.txtView_5);

        mTextView6 = view.findViewById(R.id.txtView_6);
        mTextView7 = view.findViewById(R.id.txtView_7);
        mTextView8 = view.findViewById(R.id.txtView_8);

        mTextViewXWins=view.findViewById(R.id.txtView_x_wins);
        mTextViewOWins=view.findViewById(R.id.txtView_o_wins);
        mTextViewDraw=view.findViewById(R.id.txtView_draw);

    }


    /*********************** UPDATE TEXT VIEW ARRAY *****************/
    private void updateTextViewArray() {
        mTextViewXOArray = new TextView[][]{
                {mTextView0, mTextView1, mTextView2},
                {mTextView3, mTextView4, mTextView5},
                {mTextView6, mTextView7, mTextView8}};
    }

    /*********************** SET LISTENER VIEW ************************/
    private void setListenerView() {

        myListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.txtView_0:
                        changeState(mTextView0, 0, 0);
                        Log.d("TAG", "mTextView0");
                        break;
                    case R.id.txtView_1:
                        changeState(mTextView1, 0, 1);
                        break;
                    case R.id.txtView_2:
                        changeState(mTextView2, 0, 2);
                        break;
                    case R.id.txtView_3:
                        changeState(mTextView3, 1, 0);
                        break;
                    case R.id.txtView_4:
                        changeState(mTextView4, 1, 1);
                        break;
                    case R.id.txtView_5:
                        changeState(mTextView5, 1, 2);
                        break;
                    case R.id.txtView_6:
                        changeState(mTextView6, 2, 0);
                        break;
                    case R.id.txtView_7:
                        changeState(mTextView7, 2, 1);
                        break;
                    case R.id.txtView_8:
                        changeState(mTextView8, 2, 2);
                        break;


                }
            }
        };
    }

    /************************* SET LISTENER **************/
    private void setListener() {
        mTextView0.setOnClickListener(myListner);
        mTextView1.setOnClickListener(myListner);
        mTextView2.setOnClickListener(myListner);
        mTextView3.setOnClickListener(myListner);
        mTextView4.setOnClickListener(myListner);
        mTextView5.setOnClickListener(myListner);
        mTextView6.setOnClickListener(myListner);
        mTextView7.setOnClickListener(myListner);
        mTextView8.setOnClickListener(myListner);
    }

    /************************* CHANGE STATE **********************/
    private void changeState(TextView textView, int i, int j) {
        if (mTextViewXOArray[i][j].getText()== "" && !isHaveWinner()) {
            Log.d(TAG,"we have  not not winner ");

            textView.setText("O");
            textView.setTextColor(Color.RED);
            Log.d(TAG,"game state is "+ String.valueOf(mGameState));
            mGameState++;
            randomPlay();

        } else if (isHaveWinner()) {
            Log.d(TAG,"is have winner!!!! ");
            makeToast();
            Log.d(TAG, "refresh game ");
            refreshGame();
        }
        else if(!isHaveWinner()&&mGameState==9){

           generateToast(R.string.toast_draw);
           mDraw++;
           mTextViewDraw.setText(mDraw+"");
        }


    }


    /******************************* RANDOM PLAY ***********************/

    private void randomPlay() {
        if (!isHaveWinner()&& mGameState!=9) {
            Log.d(TAG,"game state is "+ String.valueOf(mGameState));
            int[] indexes = generateRandomIndex();
            int randomI = indexes[0];
            int randomJ = indexes[1];

            while (mTextViewXOArray[randomI][randomJ].getText() != "") {
                indexes = generateRandomIndex();
                randomI = indexes[0];
                randomJ = indexes[1];
            }

            mTextViewXOArray[randomI][randomJ].setText("X");
            mTextViewXOArray[randomI][randomJ].setTextColor(Color.BLUE);
            mGameState++;

        }

    }
    /********************* GENERATE RANDOM INDEX ***************/
    public int[] generateRandomIndex() {
        int[] result = new int[2];
        result[0] = (int) (Math.random() * 3);
        result[1] = (int) (Math.random() * 3);
        return result;
    }

    /************************ IS HAVE WINNER ******************/
    public boolean isHaveWinner() {

        if (mTextViewXOArray[1][1].getText() != "") {
            if (isWinDiagonalLeft())
                return true;
            if (isWinDiagonalRight())
                return true;

        }

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (mTextViewXOArray[i][j].getText() != "") {
                    if (isWinRow(i, j))
                        return true;
                    if (isWinColumn(i, j))
                        return true;

                }


            }
        }
        return false;
    }

    /************ IS WIN DIAGONAL LEFT **************/
    public boolean isWinDiagonalLeft() {
        if (mTextViewXOArray[0][0].getText() == mTextViewXOArray[1][1].getText()
                && mTextViewXOArray[1][1].getText() == mTextViewXOArray[2][2].getText()) {

            mTextViewWinner = mTextViewXOArray[1][1];


            return true;
        }
        return false;
    }

    /************* IS WIN DIAGONAL RIGHT ************/
    public boolean isWinDiagonalRight() {
        if (mTextViewXOArray[0][2].getText() == mTextViewXOArray[1][1].getText()
                && mTextViewXOArray[1][1].getText() == mTextViewXOArray[2][0].getText()) {
            mTextViewWinner = mTextViewXOArray[1][1];

            return true;
        }
        return false;
    }

    /****************** IS WIN ROW ***************/
    public boolean isWinRow(int i, int j) {
        if (j == 0 &&
                mTextViewXOArray[i][j].getText() == mTextViewXOArray[i][j + 1].getText()
                &&
                mTextViewXOArray[i][j].getText() == mTextViewXOArray[i][j + 2].getText()) {
            mTextViewWinner = mTextViewXOArray[i][j];
            return true;
        }
        return false;
    }

    /************* IS WIN COLUMN *************/
    public boolean isWinColumn(int i, int j) {
        if (i == 0 &&
                mTextViewXOArray[i][j].getText() == mTextViewXOArray[i + 1][j].getText()
                &&
                mTextViewXOArray[i][j].getText() == mTextViewXOArray[i + 2][j].getText()) {
            mTextViewWinner = mTextViewXOArray[i][j];
            return true;
        }
        return false;
    }




    /*************************** MAKE TOAST *********************/
    public void makeToast() {
        if (mTextViewWinner.getText() == "X"){

            generateToast(R.string.toast_android_won);
            mXWins++;
            mTextViewXWins.setText(mXWins+"");
        }

        else if(mTextViewWinner.getText()=="O"){

            generateToast(R.string.toast_you_won);
            mOWins++;
            mTextViewOWins.setText(mOWins+"");
        }


    }

    /************************** REFRESH GAME ***********************/
    public void refreshGame() {

        mTextView0.setText("");
        mTextView1.setText("");
        mTextView2.setText("");
        mTextView3.setText("");
        mTextView4.setText("");
        mTextView5.setText("");
        mTextView6.setText("");
        mTextView7.setText("");
        mTextView8.setText("");
        updateTextViewArray();
        mGameState=0;


    }
    /*************** GENERATE GAME TOAST *************************/
    private void generateToast(int messageResId ) {
        Toast.makeText(getActivity(), messageResId, Toast.LENGTH_LONG).show();
    }
}