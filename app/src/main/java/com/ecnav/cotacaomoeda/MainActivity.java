package com.ecnav.cotacaomoeda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ecnav.cotacaomoeda.data.Repository;
import com.ecnav.cotacaomoeda.databinding.ActivityMainBinding;
import com.ecnav.cotacaomoeda.model.Currency;
import com.ecnav.cotacaomoeda.ui.MoreDetailsActivity;
import com.ecnav.cotacaomoeda.util.Util;
import com.google.android.material.elevation.SurfaceColors;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    private ActivityMainBinding binding;
    List<Currency> currencyList;
    private SensorManager sensorManager;
    private Sensor proximity;

    ActivityResultLauncher<Intent> launchMoreDetails = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result ->
            {
                if (result.getResultCode() == Activity.RESULT_OK)
                {
                    Intent data = result.getData();
                    assert data != null;
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //DynamicColors.applyToActivitiesIfAvailable(getApplication());
        getWindow().setStatusBarColor(SurfaceColors.SURFACE_2.getColor(this));
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        currencyList = getCurrencyInfo();

        binding.firstCurrency.setOnClickListener(view ->
        {
            Intent intent = new Intent(MainActivity.this, MoreDetailsActivity.class);
            intent.putExtra(Util.CODE, currencyList.get(0).getCode());
            intent.putExtra(Util.NAME, currencyList.get(0).getName());
            intent.putExtra(Util.BID, currencyList.get(0).getBid());
            intent.putExtra(Util.HIGH, currencyList.get(0).getHigh());
            intent.putExtra(Util.LOW, currencyList.get(0).getLow());
            intent.putExtra(Util.VARBID, currencyList.get(0).getVarBid());
            intent.putExtra(Util.PCT, currencyList.get(0).getPctChange());
            intent.putExtra(Util.ASK, currencyList.get(0).getAsk());
            intent.putExtra(Util.TIMESTAMP, currencyList.get(0).getTimestamp());
            openMoreInfo(intent);
        });

        binding.secondCurrency.setOnClickListener(view ->
        {
            Intent intent = new Intent(MainActivity.this, MoreDetailsActivity.class);
            intent.putExtra(Util.CODE, currencyList.get(1).getCode());
            intent.putExtra(Util.NAME, currencyList.get(1).getName());
            intent.putExtra(Util.BID, currencyList.get(1).getBid());
            intent.putExtra(Util.HIGH, currencyList.get(1).getHigh());
            intent.putExtra(Util.LOW, currencyList.get(1).getLow());
            intent.putExtra(Util.VARBID, currencyList.get(1).getVarBid());
            intent.putExtra(Util.PCT, currencyList.get(1).getPctChange());
            intent.putExtra(Util.ASK, currencyList.get(1).getAsk());
            intent.putExtra(Util.TIMESTAMP, currencyList.get(1).getTimestamp());
            openMoreInfo(intent);
        });

        binding.thirdCurrency.setOnClickListener(view ->
        {
            Intent intent = new Intent(MainActivity.this, MoreDetailsActivity.class);
            intent.putExtra(Util.CODE, currencyList.get(2).getCode());
            intent.putExtra(Util.NAME, currencyList.get(2).getName());
            intent.putExtra(Util.BID, currencyList.get(2).getBid());
            intent.putExtra(Util.HIGH, currencyList.get(2).getHigh());
            intent.putExtra(Util.LOW, currencyList.get(2).getLow());
            intent.putExtra(Util.VARBID, currencyList.get(2).getVarBid());
            intent.putExtra(Util.PCT, currencyList.get(2).getPctChange());
            intent.putExtra(Util.ASK, currencyList.get(2).getAsk());
            intent.putExtra(Util.TIMESTAMP, currencyList.get(2).getTimestamp());
            openMoreInfo(intent);
        });

        binding.forthCurrency.setOnClickListener(view ->
        {
            Intent intent = new Intent(MainActivity.this, MoreDetailsActivity.class);
            intent.putExtra(Util.CODE, currencyList.get(3).getCode());
            intent.putExtra(Util.NAME, currencyList.get(3).getName());
            intent.putExtra(Util.BID, currencyList.get(3).getBid());
            intent.putExtra(Util.HIGH, currencyList.get(3).getHigh());
            intent.putExtra(Util.LOW, currencyList.get(3).getLow());
            intent.putExtra(Util.VARBID, currencyList.get(3).getVarBid());
            intent.putExtra(Util.PCT, currencyList.get(3).getPctChange());
            intent.putExtra(Util.ASK, currencyList.get(3).getAsk());
            intent.putExtra(Util.TIMESTAMP, currencyList.get(3).getTimestamp());
            openMoreInfo(intent);
        });

        binding.fithCurrency.setOnClickListener(view ->
        {
            Intent intent = new Intent(MainActivity.this, MoreDetailsActivity.class);
            intent.putExtra(Util.CODE, currencyList.get(4).getCode());
            intent.putExtra(Util.NAME, currencyList.get(4).getName());
            intent.putExtra(Util.BID, currencyList.get(4).getBid());
            intent.putExtra(Util.HIGH, currencyList.get(4).getHigh());
            intent.putExtra(Util.LOW, currencyList.get(4).getLow());
            intent.putExtra(Util.VARBID, currencyList.get(4).getVarBid());
            intent.putExtra(Util.PCT, currencyList.get(4).getPctChange());
            intent.putExtra(Util.ASK, currencyList.get(4).getAsk());
            intent.putExtra(Util.TIMESTAMP, currencyList.get(4).getTimestamp());
            openMoreInfo(intent);
        });
    }

    private List<Currency> getCurrencyInfo()
    {
        return new Repository().getCurrencies(currencyArrayList -> updateCurrency());
    }

    private void updateCurrency()
    {
        binding.firstCurrencyName.setText(currencyList.get(0).getCode());
        binding.firstCurrencyHigh.setText(String.valueOf(currencyList.get(0).getHigh()));
        binding.firstCurrencyLow.setText(String.valueOf(currencyList.get(0).getLow()));
        binding.firstCurrencyBid.setText(String.valueOf(currencyList.get(0).getBid()));

        binding.secondCurrencyName.setText(currencyList.get(1).getCode());
        binding.secondCurrencyHigh.setText(String.valueOf(currencyList.get(1).getHigh()));
        binding.secondCurrencyLow.setText(String.valueOf(currencyList.get(1).getLow()));
        binding.secondCurrencyBid.setText(String.valueOf(currencyList.get(1).getBid()));

        binding.thirdCurrencyName.setText(currencyList.get(2).getCode());
        binding.thirdCurrencyHigh.setText(String.valueOf(currencyList.get(2).getHigh()));
        binding.thirdCurrencyLow.setText(String.valueOf(currencyList.get(2).getLow()));
        binding.thirdCurrencyBid.setText(String.valueOf(currencyList.get(2).getBid()));

        binding.forthCurrencyName.setText(currencyList.get(3).getCode());
        binding.forthCurrencyHigh.setText(String.valueOf(currencyList.get(3).getHigh()));
        binding.forthCurrencyLow.setText(String.valueOf(currencyList.get(3).getLow()));
        binding.forthCurrencyBid.setText(String.valueOf(currencyList.get(3).getBid()));

        binding.fithCurrencyName.setText(currencyList.get(4).getCode());
        binding.fithCurrencyHigh.setText(String.valueOf(currencyList.get(4).getHigh()));
        binding.fithCurrencyLow.setText(String.valueOf(currencyList.get(4).getLow()));
        binding.fithCurrencyBid.setText(String.valueOf(currencyList.get(4).getBid()));
    }

    public void openMoreInfo(Intent intent)
    {
        launchMoreDetails.launch(intent);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        float distance = sensorEvent.values[0];
        if (distance < 5)
        {
            getCurrencyInfo();
            Snackbar.make(binding.fithCurrency, R.string.updateNotificationText, Snackbar.LENGTH_SHORT).show();
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }
}