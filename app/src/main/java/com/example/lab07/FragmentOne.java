package com.example.lab07;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentOne extends Fragment {
    private TextView textView;
    private SendMessage1 sendMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.tvOne);

        Button btnPassData = view.findViewById(R.id.btOne);
        EditText inData = view.findViewById(R.id.etOne);
        btnPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage.sendData1(inData.getText().toString().trim());
            }
        });
    }
    interface SendMessage1 {
        void sendData1(String message);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendMessage = (SendMessage1) getActivity();

    }
    void displayReceivedData(String message) {
        textView.setText("Mensaje del fragment 2: " + message);
    }
}