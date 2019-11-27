package com.signifyd.domain;

import com.opencsv.bean.CsvBindByName;

public class Case {

    @CsvBindByName(column = "case")
    private Long caseNo;
    @CsvBindByName(column = "created_at")
    private String createdAt;
    @CsvBindByName(column = "amount")
    private String amount;
    @CsvBindByName(column = "risk_score")
    private Double riskScore;
    @CsvBindByName(column = "user_account_aggregate_order_count")
    private Integer userAccontAgg;
    @CsvBindByName(column = "merchant")
    private Integer merchant;


    public Long getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(Long caseNo) {
        this.caseNo = caseNo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Double riskScore) {
        this.riskScore = riskScore;
    }

    public Integer getUserAccontAgg() {
        return userAccontAgg;
    }

    public void setUserAccontAgg(Integer userAccontAgg) {
        this.userAccontAgg = userAccontAgg;
    }

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }


    @Override
    public String toString() {
        return "Case{" +
                "caseNo=" + caseNo +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                ", riskScore=" + riskScore +
                ", userAccontAgg=" + userAccontAgg +
                ", merchant=" + merchant +
                '}';
    }

}
