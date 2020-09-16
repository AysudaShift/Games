package com.example.games.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.games.R;
import com.example.games.controller.fragment.FourInARowFragment;
import com.example.games.controller.fragment.TicTacToeFragment;

public class MainActivity extends AppCompatActivity {
    private Button mButtonTicTacToe;
    private Button mButtonFourInARow;

    /******************** NEW INTENT **********************/
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    /*********************** ON CREATE ************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        findViews();
        setListeners();


    }

    /*************************  FIND VIEWS *********************/

    private void findViews() {
        mButtonFourInARow  = findViewById(R.id.btn_4_in_a_row);
        mButtonTicTacToe = findViewById(R.id.btn_tic_tac);
    }

    /*********************** SET LISTENERS **********************/
    private void setListeners() {
        mButtonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicTacToeFragment ticTacFragment = TicTacToeFragment.newInstance();
                addFragment(ticTacFragment);


            }
        });
        mButtonFourInARow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FourInARowFragment inARowFragment = FourInARowFragment.newInstance();
                addFragment(inARowFragment);

            }
        });
    }

    /************************ ADD FRAGMENT ***********************/
    private void addFragment(Fragment gameFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, gameFragment)
                    .commit();
        }
    }

}
