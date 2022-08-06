package com.ecnav.cotacaomoeda.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ecnav.cotacaomoeda.R;
import com.ecnav.cotacaomoeda.databinding.ActivityMoreDetailsBinding;
import com.ecnav.cotacaomoeda.util.Util;
import com.google.android.material.elevation.SurfaceColors;

public class MoreDetailsActivity extends AppCompatActivity
{
    private ActivityMoreDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_more_details);
        getWindow().setStatusBarColor(SurfaceColors.SURFACE_2.getColor(this));
        Intent intent = getIntent();
        binding.currencyName.setText(intent.getStringExtra(Util.CODE));
        binding.currencyBid.setText(String.valueOf(intent.getDoubleExtra(Util.BID, 0.0)));
        binding.currencyHigh.setText(String.valueOf(intent.getDoubleExtra(Util.HIGH, 0.0)));
        binding.currencyLow.setText(String.valueOf(intent.getDoubleExtra(Util.LOW, 0.0)));
        binding.varBidtextView.setText(String.valueOf(intent.getDoubleExtra(Util.VARBID, 0.0)));
        binding.pctTextView.setText(String.valueOf(intent.getDoubleExtra(Util.PCT, 0.0)));
        binding.askTextView.setText(String.valueOf(intent.getDoubleExtra(Util.ASK, 0.0)));
        binding.timestampTextView.setText(intent.getStringExtra(Util.TIMESTAMP));
    }
}