package com.signifyd.transform;

import com.signifyd.domain.Case;
import com.signifyd.domain.CaseTransformed;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Transform {


    /**
     * Returns the values without dollar signs
     * @param aCase
     * @return string
     */
    public CaseTransformed scrubData(Case aCase) throws ParseException {

        CaseTransformed caseTransformed = new CaseTransformed();
        caseTransformed.setCaseNo(aCase.getCaseNo());
        caseTransformed.setCreatedAt(convertDate(aCase.getCreatedAt()));

        String amount = removeDollar(aCase.getAmount());

        caseTransformed.setAmount(convertToNumber(amount));
        caseTransformed.setRiskScore(aCase.getRiskScore());
        caseTransformed.setUserAccontAgg(aCase.getUserAccontAgg());
        caseTransformed.setMerchant(aCase.getMerchant());

        return caseTransformed;

    }

    private String convertDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate = formatter.parse(date);
        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sqlDate = sqlFormat.format(newDate);
        return sqlDate;
    }

    private String removeDollar(String value){
        String transValue;
        try {
            transValue = String.valueOf(value).replace("$", "");
        }catch (Exception e){
            return  "ERR";

        }
        return transValue;

    }

    private Double convertToNumber(String value){
        double transValue;
        try {
            transValue = Double.parseDouble(value);
        }catch (NumberFormatException e){
            transValue = 0.0;
        }
        return transValue;
    }

}
