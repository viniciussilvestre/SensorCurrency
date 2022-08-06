package com.ecnav.cotacaomoeda.data;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ecnav.cotacaomoeda.controller.AppController;
import com.ecnav.cotacaomoeda.model.Currency;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository
{
    ArrayList<Currency> currencyArrayList = new ArrayList<>();
    String url = "https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL,GBP-BRL,JPY-BRL";

    public List<Currency> getCurrencies(final AnswerListAsyncResponse callBack)
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response ->
        {
            Iterator<String> iterator = response.keys();
            while(iterator.hasNext())
            {
                try
                {
                    String name = iterator.next();
                    Currency currency = new Currency(
                            response.getJSONObject(name).getString("code"),
                            response.getJSONObject(name).getString("name"),
                            Double.parseDouble(response.getJSONObject(name).getString("high")),
                            Double.parseDouble(response.getJSONObject(name).getString("low")),
                            Double.parseDouble(response.getJSONObject(name).getString("bid")),
                            Double.parseDouble(response.getJSONObject(name).getString("varBid")),
                            Double.parseDouble(response.getJSONObject(name).getString("pctChange")),
                            Double.parseDouble(response.getJSONObject(name).getString("ask")),
                            response.getJSONObject(name).getString("timestamp"));
                    currencyArrayList.add(currency);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
//            for (int i = 0; i < response.length(); i++)
//            {

//            }
            if (null != callBack)
            {
                callBack.processFinished(currencyArrayList);
            }
        }, error ->
        {

        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
        return currencyArrayList;
    }
}
