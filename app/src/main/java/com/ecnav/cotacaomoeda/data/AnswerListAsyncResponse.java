package com.ecnav.cotacaomoeda.data;

import com.ecnav.cotacaomoeda.model.Currency;

import java.util.ArrayList;

public interface AnswerListAsyncResponse
{
    void processFinished(ArrayList<Currency> currencyArrayList);
}
