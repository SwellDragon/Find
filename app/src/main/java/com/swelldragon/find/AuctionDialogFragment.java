package com.swelldragon.find;


import android.app.DialogFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AuctionDialogFragment extends DialogFragment {
    Button auction_button_dialog;
    TextView auction_price_dialog;
    EditText addprice_editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        View view = inflater.inflate(R.layout.dialog_auction, container);
        auction_button_dialog = (Button) view.findViewById(R.id.auction_button_dialog);
        auction_price_dialog = (TextView) view.findViewById(R.id.auction_price_dialog);
        addprice_editText = (EditText) view.findViewById(R.id.addprice_editText);
        Bundle bundle = getArguments();
        final Sale_List_Object sale_list_object = bundle.getParcelable("thissale");
        auction_price_dialog.setText(String.valueOf(sale_list_object.getPrice()));
        auction_button_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addprice_editText.getText().toString().equals("")){

                }
                else{
                    Float add=Float.valueOf(addprice_editText.getText().toString());
                    Float nextprice = sale_list_object.getPrice()+add;
                    Sale_List_Object sale_list_object1 = new Sale_List_Object();
                    sale_list_object1.setPrice(nextprice);
                    sale_list_object1.updateAll("name = ?",sale_list_object.getName());
                    TextView textView=(TextView)getActivity().findViewById(R.id.auction_price);
                    textView.setText(String.valueOf(nextprice));
                    dismiss();
                }

            }
        });
        return view;
    }
}
