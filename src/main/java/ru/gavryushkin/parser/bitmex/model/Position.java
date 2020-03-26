package ru.gavryushkin.parser.bitmex.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Summary of Open and Closed Positions
 */
@ApiModel(description = "Summary of Open and Closed Positions")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-17T20:26:16.019-05:00")
public class Position {
    @SerializedName("account")
    private BigDecimal account = null;

    @SerializedName("symbol")
    private String symbol = null;

    @SerializedName("currency")
    private String currency = null;

    @SerializedName("underlying")
    private String underlying = null;

    @SerializedName("quoteCurrency")
    private String quoteCurrency = null;

    @SerializedName("commission")
    private Double commission = 0.0d;

    @SerializedName("initMarginReq")
    private Double initMarginReq = 0.0d;

    @SerializedName("maintMarginReq")
    private Double maintMarginReq = 0.0d;

    @SerializedName("riskLimit")
    private BigDecimal riskLimit = null;

    @SerializedName("leverage")
    private Double leverage = 0.0d;

    @SerializedName("crossMargin")
    private Boolean crossMargin = null;

    @SerializedName("deleveragePercentile")
    private Double deleveragePercentile = 0.0d;

    @SerializedName("rebalancedPnl")
    private BigDecimal rebalancedPnl = null;

    @SerializedName("prevRealisedPnl")
    private BigDecimal prevRealisedPnl = null;

    @SerializedName("prevUnrealisedPnl")
    private BigDecimal prevUnrealisedPnl = null;

    @SerializedName("prevClosePrice")
    private Double prevClosePrice = 0.0d;

    @SerializedName("openingTimestamp")
    private String openingTimestamp = null;

    @SerializedName("openingQty")
    private BigDecimal openingQty = null;

    @SerializedName("openingCost")
    private BigDecimal openingCost = null;

    @SerializedName("openingComm")
    private BigDecimal openingComm = null;

    @SerializedName("openOrderBuyQty")
    private BigDecimal openOrderBuyQty = null;

    @SerializedName("openOrderBuyCost")
    private BigDecimal openOrderBuyCost = null;

    @SerializedName("openOrderBuyPremium")
    private BigDecimal openOrderBuyPremium = null;

    @SerializedName("openOrderSellQty")
    private BigDecimal openOrderSellQty = null;

    @SerializedName("openOrderSellCost")
    private BigDecimal openOrderSellCost = null;

    @SerializedName("openOrderSellPremium")
    private BigDecimal openOrderSellPremium = null;

    @SerializedName("execBuyQty")
    private BigDecimal execBuyQty = null;

    @SerializedName("execBuyCost")
    private BigDecimal execBuyCost = null;

    @SerializedName("execSellQty")
    private BigDecimal execSellQty = null;

    @SerializedName("execSellCost")
    private BigDecimal execSellCost = null;

    @SerializedName("execQty")
    private BigDecimal execQty = null;

    @SerializedName("execCost")
    private BigDecimal execCost = null;

    @SerializedName("execComm")
    private BigDecimal execComm = null;

    @SerializedName("currentTimestamp")
    private String currentTimestamp = null;

    @SerializedName("currentQty")
    private BigDecimal currentQty = null;

    @SerializedName("currentCost")
    private BigDecimal currentCost = null;

    @SerializedName("currentComm")
    private BigDecimal currentComm = null;

    @SerializedName("realisedCost")
    private BigDecimal realisedCost = null;

    @SerializedName("unrealisedCost")
    private BigDecimal unrealisedCost = null;

    @SerializedName("grossOpenCost")
    private BigDecimal grossOpenCost = null;

    @SerializedName("grossOpenPremium")
    private BigDecimal grossOpenPremium = null;

    @SerializedName("grossExecCost")
    private BigDecimal grossExecCost = null;

    @SerializedName("isOpen")
    private Boolean isOpen = null;

    @SerializedName("markPrice")
    private Double markPrice = 0.0d;

    @SerializedName("markValue")
    private BigDecimal markValue = null;

    @SerializedName("riskValue")
    private BigDecimal riskValue = null;

    @SerializedName("homeNotional")
    private Double homeNotional = 0.0d;

    @SerializedName("foreignNotional")
    private Double foreignNotional = 0.0d;

    @SerializedName("posState")
    private String posState = null;

    @SerializedName("posCost")
    private BigDecimal posCost = null;

    @SerializedName("posCost2")
    private BigDecimal posCost2 = null;

    @SerializedName("posCross")
    private BigDecimal posCross = null;

    @SerializedName("posInit")
    private BigDecimal posInit = null;

    @SerializedName("posComm")
    private BigDecimal posComm = null;

    @SerializedName("posLoss")
    private BigDecimal posLoss = null;

    @SerializedName("posMargin")
    private BigDecimal posMargin = null;

    @SerializedName("posMaint")
    private BigDecimal posMaint = null;

    @SerializedName("posAllowance")
    private BigDecimal posAllowance = null;

    @SerializedName("taxableMargin")
    private BigDecimal taxableMargin = null;

    @SerializedName("initMargin")
    private BigDecimal initMargin = null;

    @SerializedName("maintMargin")
    private BigDecimal maintMargin = null;

    @SerializedName("sessionMargin")
    private BigDecimal sessionMargin = null;

    @SerializedName("targetExcessMargin")
    private BigDecimal targetExcessMargin = null;

    @SerializedName("varMargin")
    private BigDecimal varMargin = null;

    @SerializedName("realisedGrossPnl")
    private BigDecimal realisedGrossPnl = null;

    @SerializedName("realisedTax")
    private BigDecimal realisedTax = null;

    @SerializedName("realisedPnl")
    private BigDecimal realisedPnl = null;

    @SerializedName("unrealisedGrossPnl")
    private BigDecimal unrealisedGrossPnl = null;

    @SerializedName("longBankrupt")
    private BigDecimal longBankrupt = null;

    @SerializedName("shortBankrupt")
    private BigDecimal shortBankrupt = null;

    @SerializedName("taxBase")
    private BigDecimal taxBase = null;

    @SerializedName("indicativeTaxRate")
    private Double indicativeTaxRate = 0.0d;

    @SerializedName("indicativeTax")
    private BigDecimal indicativeTax = null;

    @SerializedName("unrealisedTax")
    private BigDecimal unrealisedTax = null;

    @SerializedName("unrealisedPnl")
    private BigDecimal unrealisedPnl = null;

    @SerializedName("unrealisedPnlPcnt")
    private Double unrealisedPnlPcnt = 0.0d;

    @SerializedName("unrealisedRoePcnt")
    private Double unrealisedRoePcnt = 0.0d;

    @SerializedName("simpleQty")
    private Double simpleQty = 0.0d;

    @SerializedName("simpleCost")
    private Double simpleCost = 0.0d;

    @SerializedName("simpleValue")
    private Double simpleValue = 0.0d;

    @SerializedName("simplePnl")
    private Double simplePnl = 0.0d;

    @SerializedName("simplePnlPcnt")
    private Double simplePnlPcnt = 0.0d;

    @SerializedName("avgCostPrice")
    private Double avgCostPrice = 0.0d;

    @SerializedName("avgEntryPrice")
    private Double avgEntryPrice = 0.0d;

    @SerializedName("breakEvenPrice")
    private Double breakEvenPrice = 0.0d;

    @SerializedName("marginCallPrice")
    private Double marginCallPrice = 0.0d;

    @SerializedName("liquidationPrice")
    private Double liquidationPrice = 0.0d;

    @SerializedName("bankruptPrice")
    private Double bankruptPrice = 0.0d;

    @SerializedName("timestamp")
    private String timestamp = null;

    @SerializedName("lastPrice")
    private Double lastPrice = 0.0d;

    @SerializedName("lastValue")
    private BigDecimal lastValue = null;

    public Position account(BigDecimal account) {
        this.account = account;
        return this;
    }

    /**
     * Get account
     * @return account
     **/
    @ApiModelProperty(required = true, value = "")
    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public Position symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    /**
     * Get symbol
     * @return symbol
     **/
    @ApiModelProperty(required = true, value = "")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Position currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     * @return currency
     **/
    @ApiModelProperty(required = true, value = "")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Position underlying(String underlying) {
        this.underlying = underlying;
        return this;
    }

    /**
     * Get underlying
     * @return underlying
     **/
    @ApiModelProperty(value = "")
    public String getUnderlying() {
        return underlying;
    }

    public void setUnderlying(String underlying) {
        this.underlying = underlying;
    }

    public Position quoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
        return this;
    }

    /**
     * Get quoteCurrency
     * @return quoteCurrency
     **/
    @ApiModelProperty(value = "")
    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public Position commission(Double commission) {
        this.commission = commission;
        return this;
    }

    /**
     * Get commission
     * @return commission
     **/
    @ApiModelProperty(value = "")
    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Position initMarginReq(Double initMarginReq) {
        this.initMarginReq = initMarginReq;
        return this;
    }

    /**
     * Get initMarginReq
     * @return initMarginReq
     **/
    @ApiModelProperty(value = "")
    public Double getInitMarginReq() {
        return initMarginReq;
    }

    public void setInitMarginReq(Double initMarginReq) {
        this.initMarginReq = initMarginReq;
    }

    public Position maintMarginReq(Double maintMarginReq) {
        this.maintMarginReq = maintMarginReq;
        return this;
    }

    /**
     * Get maintMarginReq
     * @return maintMarginReq
     **/
    @ApiModelProperty(value = "")
    public Double getMaintMarginReq() {
        return maintMarginReq;
    }

    public void setMaintMarginReq(Double maintMarginReq) {
        this.maintMarginReq = maintMarginReq;
    }

    public Position riskLimit(BigDecimal riskLimit) {
        this.riskLimit = riskLimit;
        return this;
    }

    /**
     * Get riskLimit
     * @return riskLimit
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getRiskLimit() {
        return riskLimit;
    }

    public void setRiskLimit(BigDecimal riskLimit) {
        this.riskLimit = riskLimit;
    }

    public Position leverage(Double leverage) {
        this.leverage = leverage;
        return this;
    }

    /**
     * Get leverage
     * @return leverage
     **/
    @ApiModelProperty(value = "")
    public Double getLeverage() {
        return leverage;
    }

    public void setLeverage(Double leverage) {
        this.leverage = leverage;
    }

    public Position crossMargin(Boolean crossMargin) {
        this.crossMargin = crossMargin;
        return this;
    }

    /**
     * Get crossMargin
     * @return crossMargin
     **/
    @ApiModelProperty(value = "")
    public Boolean isCrossMargin() {
        return crossMargin;
    }

    public void setCrossMargin(Boolean crossMargin) {
        this.crossMargin = crossMargin;
    }

    public Position deleveragePercentile(Double deleveragePercentile) {
        this.deleveragePercentile = deleveragePercentile;
        return this;
    }

    /**
     * Get deleveragePercentile
     * @return deleveragePercentile
     **/
    @ApiModelProperty(value = "")
    public Double getDeleveragePercentile() {
        return deleveragePercentile;
    }

    public void setDeleveragePercentile(Double deleveragePercentile) {
        this.deleveragePercentile = deleveragePercentile;
    }

    public Position rebalancedPnl(BigDecimal rebalancedPnl) {
        this.rebalancedPnl = rebalancedPnl;
        return this;
    }

    /**
     * Get rebalancedPnl
     * @return rebalancedPnl
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getRebalancedPnl() {
        return rebalancedPnl;
    }

    public void setRebalancedPnl(BigDecimal rebalancedPnl) {
        this.rebalancedPnl = rebalancedPnl;
    }

    public Position prevRealisedPnl(BigDecimal prevRealisedPnl) {
        this.prevRealisedPnl = prevRealisedPnl;
        return this;
    }

    /**
     * Get prevRealisedPnl
     * @return prevRealisedPnl
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPrevRealisedPnl() {
        return prevRealisedPnl;
    }

    public void setPrevRealisedPnl(BigDecimal prevRealisedPnl) {
        this.prevRealisedPnl = prevRealisedPnl;
    }

    public Position prevUnrealisedPnl(BigDecimal prevUnrealisedPnl) {
        this.prevUnrealisedPnl = prevUnrealisedPnl;
        return this;
    }

    /**
     * Get prevUnrealisedPnl
     * @return prevUnrealisedPnl
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPrevUnrealisedPnl() {
        return prevUnrealisedPnl;
    }

    public void setPrevUnrealisedPnl(BigDecimal prevUnrealisedPnl) {
        this.prevUnrealisedPnl = prevUnrealisedPnl;
    }

    public Position prevClosePrice(Double prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
        return this;
    }

    /**
     * Get prevClosePrice
     * @return prevClosePrice
     **/
    @ApiModelProperty(value = "")
    public Double getPrevClosePrice() {
        return prevClosePrice;
    }

    public void setPrevClosePrice(Double prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }

    public Position openingTimestamp(String openingTimestamp) {
        this.openingTimestamp = openingTimestamp;
        return this;
    }

    /**
     * Get openingTimestamp
     * @return openingTimestamp
     **/
    @ApiModelProperty(value = "")
    public String getOpeningTimestamp() {
        return openingTimestamp;
    }

    public void setOpeningTimestamp(String openingTimestamp) {
        this.openingTimestamp = openingTimestamp;
    }

    public Position openingQty(BigDecimal openingQty) {
        this.openingQty = openingQty;
        return this;
    }

    /**
     * Get openingQty
     * @return openingQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpeningQty() {
        return openingQty;
    }

    public void setOpeningQty(BigDecimal openingQty) {
        this.openingQty = openingQty;
    }

    public Position openingCost(BigDecimal openingCost) {
        this.openingCost = openingCost;
        return this;
    }

    /**
     * Get openingCost
     * @return openingCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpeningCost() {
        return openingCost;
    }

    public void setOpeningCost(BigDecimal openingCost) {
        this.openingCost = openingCost;
    }

    public Position openingComm(BigDecimal openingComm) {
        this.openingComm = openingComm;
        return this;
    }

    /**
     * Get openingComm
     * @return openingComm
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpeningComm() {
        return openingComm;
    }

    public void setOpeningComm(BigDecimal openingComm) {
        this.openingComm = openingComm;
    }

    public Position openOrderBuyQty(BigDecimal openOrderBuyQty) {
        this.openOrderBuyQty = openOrderBuyQty;
        return this;
    }

    /**
     * Get openOrderBuyQty
     * @return openOrderBuyQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpenOrderBuyQty() {
        return openOrderBuyQty;
    }

    public void setOpenOrderBuyQty(BigDecimal openOrderBuyQty) {
        this.openOrderBuyQty = openOrderBuyQty;
    }

    public Position openOrderBuyCost(BigDecimal openOrderBuyCost) {
        this.openOrderBuyCost = openOrderBuyCost;
        return this;
    }

    /**
     * Get openOrderBuyCost
     * @return openOrderBuyCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpenOrderBuyCost() {
        return openOrderBuyCost;
    }

    public void setOpenOrderBuyCost(BigDecimal openOrderBuyCost) {
        this.openOrderBuyCost = openOrderBuyCost;
    }

    public Position openOrderBuyPremium(BigDecimal openOrderBuyPremium) {
        this.openOrderBuyPremium = openOrderBuyPremium;
        return this;
    }

    /**
     * Get openOrderBuyPremium
     * @return openOrderBuyPremium
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpenOrderBuyPremium() {
        return openOrderBuyPremium;
    }

    public void setOpenOrderBuyPremium(BigDecimal openOrderBuyPremium) {
        this.openOrderBuyPremium = openOrderBuyPremium;
    }

    public Position openOrderSellQty(BigDecimal openOrderSellQty) {
        this.openOrderSellQty = openOrderSellQty;
        return this;
    }

    /**
     * Get openOrderSellQty
     * @return openOrderSellQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpenOrderSellQty() {
        return openOrderSellQty;
    }

    public void setOpenOrderSellQty(BigDecimal openOrderSellQty) {
        this.openOrderSellQty = openOrderSellQty;
    }

    public Position openOrderSellCost(BigDecimal openOrderSellCost) {
        this.openOrderSellCost = openOrderSellCost;
        return this;
    }

    /**
     * Get openOrderSellCost
     * @return openOrderSellCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpenOrderSellCost() {
        return openOrderSellCost;
    }

    public void setOpenOrderSellCost(BigDecimal openOrderSellCost) {
        this.openOrderSellCost = openOrderSellCost;
    }

    public Position openOrderSellPremium(BigDecimal openOrderSellPremium) {
        this.openOrderSellPremium = openOrderSellPremium;
        return this;
    }

    /**
     * Get openOrderSellPremium
     * @return openOrderSellPremium
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOpenOrderSellPremium() {
        return openOrderSellPremium;
    }

    public void setOpenOrderSellPremium(BigDecimal openOrderSellPremium) {
        this.openOrderSellPremium = openOrderSellPremium;
    }

    public Position execBuyQty(BigDecimal execBuyQty) {
        this.execBuyQty = execBuyQty;
        return this;
    }

    /**
     * Get execBuyQty
     * @return execBuyQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getExecBuyQty() {
        return execBuyQty;
    }

    public void setExecBuyQty(BigDecimal execBuyQty) {
        this.execBuyQty = execBuyQty;
    }

    public Position execBuyCost(BigDecimal execBuyCost) {
        this.execBuyCost = execBuyCost;
        return this;
    }

    /**
     * Get execBuyCost
     * @return execBuyCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getExecBuyCost() {
        return execBuyCost;
    }

    public void setExecBuyCost(BigDecimal execBuyCost) {
        this.execBuyCost = execBuyCost;
    }

    public Position execSellQty(BigDecimal execSellQty) {
        this.execSellQty = execSellQty;
        return this;
    }

    /**
     * Get execSellQty
     * @return execSellQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getExecSellQty() {
        return execSellQty;
    }

    public void setExecSellQty(BigDecimal execSellQty) {
        this.execSellQty = execSellQty;
    }

    public Position execSellCost(BigDecimal execSellCost) {
        this.execSellCost = execSellCost;
        return this;
    }

    /**
     * Get execSellCost
     * @return execSellCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getExecSellCost() {
        return execSellCost;
    }

    public void setExecSellCost(BigDecimal execSellCost) {
        this.execSellCost = execSellCost;
    }

    public Position execQty(BigDecimal execQty) {
        this.execQty = execQty;
        return this;
    }

    /**
     * Get execQty
     * @return execQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getExecQty() {
        return execQty;
    }

    public void setExecQty(BigDecimal execQty) {
        this.execQty = execQty;
    }

    public Position execCost(BigDecimal execCost) {
        this.execCost = execCost;
        return this;
    }

    /**
     * Get execCost
     * @return execCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getExecCost() {
        return execCost;
    }

    public void setExecCost(BigDecimal execCost) {
        this.execCost = execCost;
    }

    public Position execComm(BigDecimal execComm) {
        this.execComm = execComm;
        return this;
    }

    /**
     * Get execComm
     * @return execComm
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getExecComm() {
        return execComm;
    }

    public void setExecComm(BigDecimal execComm) {
        this.execComm = execComm;
    }

    public Position currentTimestamp(String currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
        return this;
    }

    /**
     * Get currentTimestamp
     * @return currentTimestamp
     **/
    @ApiModelProperty(value = "")
    public String getCurrentTimestamp() {
        return currentTimestamp;
    }

    public void setCurrentTimestamp(String currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }

    public Position currentQty(BigDecimal currentQty) {
        this.currentQty = currentQty;
        return this;
    }

    /**
     * Get currentQty
     * @return currentQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(BigDecimal currentQty) {
        this.currentQty = currentQty;
    }

    public Position currentCost(BigDecimal currentCost) {
        this.currentCost = currentCost;
        return this;
    }

    /**
     * Get currentCost
     * @return currentCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(BigDecimal currentCost) {
        this.currentCost = currentCost;
    }

    public Position currentComm(BigDecimal currentComm) {
        this.currentComm = currentComm;
        return this;
    }

    /**
     * Get currentComm
     * @return currentComm
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getCurrentComm() {
        return currentComm;
    }

    public void setCurrentComm(BigDecimal currentComm) {
        this.currentComm = currentComm;
    }

    public Position realisedCost(BigDecimal realisedCost) {
        this.realisedCost = realisedCost;
        return this;
    }

    /**
     * Get realisedCost
     * @return realisedCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getRealisedCost() {
        return realisedCost;
    }

    public void setRealisedCost(BigDecimal realisedCost) {
        this.realisedCost = realisedCost;
    }

    public Position unrealisedCost(BigDecimal unrealisedCost) {
        this.unrealisedCost = unrealisedCost;
        return this;
    }

    /**
     * Get unrealisedCost
     * @return unrealisedCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getUnrealisedCost() {
        return unrealisedCost;
    }

    public void setUnrealisedCost(BigDecimal unrealisedCost) {
        this.unrealisedCost = unrealisedCost;
    }

    public Position grossOpenCost(BigDecimal grossOpenCost) {
        this.grossOpenCost = grossOpenCost;
        return this;
    }

    /**
     * Get grossOpenCost
     * @return grossOpenCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getGrossOpenCost() {
        return grossOpenCost;
    }

    public void setGrossOpenCost(BigDecimal grossOpenCost) {
        this.grossOpenCost = grossOpenCost;
    }

    public Position grossOpenPremium(BigDecimal grossOpenPremium) {
        this.grossOpenPremium = grossOpenPremium;
        return this;
    }

    /**
     * Get grossOpenPremium
     * @return grossOpenPremium
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getGrossOpenPremium() {
        return grossOpenPremium;
    }

    public void setGrossOpenPremium(BigDecimal grossOpenPremium) {
        this.grossOpenPremium = grossOpenPremium;
    }

    public Position grossExecCost(BigDecimal grossExecCost) {
        this.grossExecCost = grossExecCost;
        return this;
    }

    /**
     * Get grossExecCost
     * @return grossExecCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getGrossExecCost() {
        return grossExecCost;
    }

    public void setGrossExecCost(BigDecimal grossExecCost) {
        this.grossExecCost = grossExecCost;
    }

    public Position isOpen(Boolean isOpen) {
        this.isOpen = isOpen;
        return this;
    }

    /**
     * Get isOpen
     * @return isOpen
     **/
    @ApiModelProperty(value = "")
    public Boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Position markPrice(Double markPrice) {
        this.markPrice = markPrice;
        return this;
    }

    /**
     * Get markPrice
     * @return markPrice
     **/
    @ApiModelProperty(value = "")
    public Double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(Double markPrice) {
        this.markPrice = markPrice;
    }

    public Position markValue(BigDecimal markValue) {
        this.markValue = markValue;
        return this;
    }

    /**
     * Get markValue
     * @return markValue
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getMarkValue() {
        return markValue;
    }

    public void setMarkValue(BigDecimal markValue) {
        this.markValue = markValue;
    }

    public Position riskValue(BigDecimal riskValue) {
        this.riskValue = riskValue;
        return this;
    }

    /**
     * Get riskValue
     * @return riskValue
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getRiskValue() {
        return riskValue;
    }

    public void setRiskValue(BigDecimal riskValue) {
        this.riskValue = riskValue;
    }

    public Position homeNotional(Double homeNotional) {
        this.homeNotional = homeNotional;
        return this;
    }

    /**
     * Get homeNotional
     * @return homeNotional
     **/
    @ApiModelProperty(value = "")
    public Double getHomeNotional() {
        return homeNotional;
    }

    public void setHomeNotional(Double homeNotional) {
        this.homeNotional = homeNotional;
    }

    public Position foreignNotional(Double foreignNotional) {
        this.foreignNotional = foreignNotional;
        return this;
    }

    /**
     * Get foreignNotional
     * @return foreignNotional
     **/
    @ApiModelProperty(value = "")
    public Double getForeignNotional() {
        return foreignNotional;
    }

    public void setForeignNotional(Double foreignNotional) {
        this.foreignNotional = foreignNotional;
    }

    public Position posState(String posState) {
        this.posState = posState;
        return this;
    }

    /**
     * Get posState
     * @return posState
     **/
    @ApiModelProperty(value = "")
    public String getPosState() {
        return posState;
    }

    public void setPosState(String posState) {
        this.posState = posState;
    }

    public Position posCost(BigDecimal posCost) {
        this.posCost = posCost;
        return this;
    }

    /**
     * Get posCost
     * @return posCost
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosCost() {
        return posCost;
    }

    public void setPosCost(BigDecimal posCost) {
        this.posCost = posCost;
    }

    public Position posCost2(BigDecimal posCost2) {
        this.posCost2 = posCost2;
        return this;
    }

    /**
     * Get posCost2
     * @return posCost2
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosCost2() {
        return posCost2;
    }

    public void setPosCost2(BigDecimal posCost2) {
        this.posCost2 = posCost2;
    }

    public Position posCross(BigDecimal posCross) {
        this.posCross = posCross;
        return this;
    }

    /**
     * Get posCross
     * @return posCross
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosCross() {
        return posCross;
    }

    public void setPosCross(BigDecimal posCross) {
        this.posCross = posCross;
    }

    public Position posInit(BigDecimal posInit) {
        this.posInit = posInit;
        return this;
    }

    /**
     * Get posInit
     * @return posInit
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosInit() {
        return posInit;
    }

    public void setPosInit(BigDecimal posInit) {
        this.posInit = posInit;
    }

    public Position posComm(BigDecimal posComm) {
        this.posComm = posComm;
        return this;
    }

    /**
     * Get posComm
     * @return posComm
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosComm() {
        return posComm;
    }

    public void setPosComm(BigDecimal posComm) {
        this.posComm = posComm;
    }

    public Position posLoss(BigDecimal posLoss) {
        this.posLoss = posLoss;
        return this;
    }

    /**
     * Get posLoss
     * @return posLoss
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosLoss() {
        return posLoss;
    }

    public void setPosLoss(BigDecimal posLoss) {
        this.posLoss = posLoss;
    }

    public Position posMargin(BigDecimal posMargin) {
        this.posMargin = posMargin;
        return this;
    }

    /**
     * Get posMargin
     * @return posMargin
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosMargin() {
        return posMargin;
    }

    public void setPosMargin(BigDecimal posMargin) {
        this.posMargin = posMargin;
    }

    public Position posMaint(BigDecimal posMaint) {
        this.posMaint = posMaint;
        return this;
    }

    /**
     * Get posMaint
     * @return posMaint
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosMaint() {
        return posMaint;
    }

    public void setPosMaint(BigDecimal posMaint) {
        this.posMaint = posMaint;
    }

    public Position posAllowance(BigDecimal posAllowance) {
        this.posAllowance = posAllowance;
        return this;
    }

    /**
     * Get posAllowance
     * @return posAllowance
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getPosAllowance() {
        return posAllowance;
    }

    public void setPosAllowance(BigDecimal posAllowance) {
        this.posAllowance = posAllowance;
    }

    public Position taxableMargin(BigDecimal taxableMargin) {
        this.taxableMargin = taxableMargin;
        return this;
    }

    /**
     * Get taxableMargin
     * @return taxableMargin
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getTaxableMargin() {
        return taxableMargin;
    }

    public void setTaxableMargin(BigDecimal taxableMargin) {
        this.taxableMargin = taxableMargin;
    }

    public Position initMargin(BigDecimal initMargin) {
        this.initMargin = initMargin;
        return this;
    }

    /**
     * Get initMargin
     * @return initMargin
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getInitMargin() {
        return initMargin;
    }

    public void setInitMargin(BigDecimal initMargin) {
        this.initMargin = initMargin;
    }

    public Position maintMargin(BigDecimal maintMargin) {
        this.maintMargin = maintMargin;
        return this;
    }

    /**
     * Get maintMargin
     * @return maintMargin
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(BigDecimal maintMargin) {
        this.maintMargin = maintMargin;
    }

    public Position sessionMargin(BigDecimal sessionMargin) {
        this.sessionMargin = sessionMargin;
        return this;
    }

    /**
     * Get sessionMargin
     * @return sessionMargin
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getSessionMargin() {
        return sessionMargin;
    }

    public void setSessionMargin(BigDecimal sessionMargin) {
        this.sessionMargin = sessionMargin;
    }

    public Position targetExcessMargin(BigDecimal targetExcessMargin) {
        this.targetExcessMargin = targetExcessMargin;
        return this;
    }

    /**
     * Get targetExcessMargin
     * @return targetExcessMargin
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getTargetExcessMargin() {
        return targetExcessMargin;
    }

    public void setTargetExcessMargin(BigDecimal targetExcessMargin) {
        this.targetExcessMargin = targetExcessMargin;
    }

    public Position varMargin(BigDecimal varMargin) {
        this.varMargin = varMargin;
        return this;
    }

    /**
     * Get varMargin
     * @return varMargin
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getVarMargin() {
        return varMargin;
    }

    public void setVarMargin(BigDecimal varMargin) {
        this.varMargin = varMargin;
    }

    public Position realisedGrossPnl(BigDecimal realisedGrossPnl) {
        this.realisedGrossPnl = realisedGrossPnl;
        return this;
    }

    /**
     * Get realisedGrossPnl
     * @return realisedGrossPnl
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getRealisedGrossPnl() {
        return realisedGrossPnl;
    }

    public void setRealisedGrossPnl(BigDecimal realisedGrossPnl) {
        this.realisedGrossPnl = realisedGrossPnl;
    }

    public Position realisedTax(BigDecimal realisedTax) {
        this.realisedTax = realisedTax;
        return this;
    }

    /**
     * Get realisedTax
     * @return realisedTax
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getRealisedTax() {
        return realisedTax;
    }

    public void setRealisedTax(BigDecimal realisedTax) {
        this.realisedTax = realisedTax;
    }

    public Position realisedPnl(BigDecimal realisedPnl) {
        this.realisedPnl = realisedPnl;
        return this;
    }

    /**
     * Get realisedPnl
     * @return realisedPnl
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getRealisedPnl() {
        return realisedPnl;
    }

    public void setRealisedPnl(BigDecimal realisedPnl) {
        this.realisedPnl = realisedPnl;
    }

    public Position unrealisedGrossPnl(BigDecimal unrealisedGrossPnl) {
        this.unrealisedGrossPnl = unrealisedGrossPnl;
        return this;
    }

    /**
     * Get unrealisedGrossPnl
     * @return unrealisedGrossPnl
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getUnrealisedGrossPnl() {
        return unrealisedGrossPnl;
    }

    public void setUnrealisedGrossPnl(BigDecimal unrealisedGrossPnl) {
        this.unrealisedGrossPnl = unrealisedGrossPnl;
    }

    public Position longBankrupt(BigDecimal longBankrupt) {
        this.longBankrupt = longBankrupt;
        return this;
    }

    /**
     * Get longBankrupt
     * @return longBankrupt
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getLongBankrupt() {
        return longBankrupt;
    }

    public void setLongBankrupt(BigDecimal longBankrupt) {
        this.longBankrupt = longBankrupt;
    }

    public Position shortBankrupt(BigDecimal shortBankrupt) {
        this.shortBankrupt = shortBankrupt;
        return this;
    }

    /**
     * Get shortBankrupt
     * @return shortBankrupt
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getShortBankrupt() {
        return shortBankrupt;
    }

    public void setShortBankrupt(BigDecimal shortBankrupt) {
        this.shortBankrupt = shortBankrupt;
    }

    public Position taxBase(BigDecimal taxBase) {
        this.taxBase = taxBase;
        return this;
    }

    /**
     * Get taxBase
     * @return taxBase
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getTaxBase() {
        return taxBase;
    }

    public void setTaxBase(BigDecimal taxBase) {
        this.taxBase = taxBase;
    }

    public Position indicativeTaxRate(Double indicativeTaxRate) {
        this.indicativeTaxRate = indicativeTaxRate;
        return this;
    }

    /**
     * Get indicativeTaxRate
     * @return indicativeTaxRate
     **/
    @ApiModelProperty(value = "")
    public Double getIndicativeTaxRate() {
        return indicativeTaxRate;
    }

    public void setIndicativeTaxRate(Double indicativeTaxRate) {
        this.indicativeTaxRate = indicativeTaxRate;
    }

    public Position indicativeTax(BigDecimal indicativeTax) {
        this.indicativeTax = indicativeTax;
        return this;
    }

    /**
     * Get indicativeTax
     * @return indicativeTax
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getIndicativeTax() {
        return indicativeTax;
    }

    public void setIndicativeTax(BigDecimal indicativeTax) {
        this.indicativeTax = indicativeTax;
    }

    public Position unrealisedTax(BigDecimal unrealisedTax) {
        this.unrealisedTax = unrealisedTax;
        return this;
    }

    /**
     * Get unrealisedTax
     * @return unrealisedTax
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getUnrealisedTax() {
        return unrealisedTax;
    }

    public void setUnrealisedTax(BigDecimal unrealisedTax) {
        this.unrealisedTax = unrealisedTax;
    }

    public Position unrealisedPnl(BigDecimal unrealisedPnl) {
        this.unrealisedPnl = unrealisedPnl;
        return this;
    }

    /**
     * Get unrealisedPnl
     * @return unrealisedPnl
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getUnrealisedPnl() {
        return unrealisedPnl;
    }

    public void setUnrealisedPnl(BigDecimal unrealisedPnl) {
        this.unrealisedPnl = unrealisedPnl;
    }

    public Position unrealisedPnlPcnt(Double unrealisedPnlPcnt) {
        this.unrealisedPnlPcnt = unrealisedPnlPcnt;
        return this;
    }

    /**
     * Get unrealisedPnlPcnt
     * @return unrealisedPnlPcnt
     **/
    @ApiModelProperty(value = "")
    public Double getUnrealisedPnlPcnt() {
        return unrealisedPnlPcnt;
    }

    public void setUnrealisedPnlPcnt(Double unrealisedPnlPcnt) {
        this.unrealisedPnlPcnt = unrealisedPnlPcnt;
    }

    public Position unrealisedRoePcnt(Double unrealisedRoePcnt) {
        this.unrealisedRoePcnt = unrealisedRoePcnt;
        return this;
    }

    /**
     * Get unrealisedRoePcnt
     * @return unrealisedRoePcnt
     **/
    @ApiModelProperty(value = "")
    public Double getUnrealisedRoePcnt() {
        return unrealisedRoePcnt;
    }

    public void setUnrealisedRoePcnt(Double unrealisedRoePcnt) {
        this.unrealisedRoePcnt = unrealisedRoePcnt;
    }

    public Position simpleQty(Double simpleQty) {
        this.simpleQty = simpleQty;
        return this;
    }

    /**
     * Get simpleQty
     * @return simpleQty
     **/
    @ApiModelProperty(value = "")
    public Double getSimpleQty() {
        return simpleQty;
    }

    public void setSimpleQty(Double simpleQty) {
        this.simpleQty = simpleQty;
    }

    public Position simpleCost(Double simpleCost) {
        this.simpleCost = simpleCost;
        return this;
    }

    /**
     * Get simpleCost
     * @return simpleCost
     **/
    @ApiModelProperty(value = "")
    public Double getSimpleCost() {
        return simpleCost;
    }

    public void setSimpleCost(Double simpleCost) {
        this.simpleCost = simpleCost;
    }

    public Position simpleValue(Double simpleValue) {
        this.simpleValue = simpleValue;
        return this;
    }

    /**
     * Get simpleValue
     * @return simpleValue
     **/
    @ApiModelProperty(value = "")
    public Double getSimpleValue() {
        return simpleValue;
    }

    public void setSimpleValue(Double simpleValue) {
        this.simpleValue = simpleValue;
    }

    public Position simplePnl(Double simplePnl) {
        this.simplePnl = simplePnl;
        return this;
    }

    /**
     * Get simplePnl
     * @return simplePnl
     **/
    @ApiModelProperty(value = "")
    public Double getSimplePnl() {
        return simplePnl;
    }

    public void setSimplePnl(Double simplePnl) {
        this.simplePnl = simplePnl;
    }

    public Position simplePnlPcnt(Double simplePnlPcnt) {
        this.simplePnlPcnt = simplePnlPcnt;
        return this;
    }

    /**
     * Get simplePnlPcnt
     * @return simplePnlPcnt
     **/
    @ApiModelProperty(value = "")
    public Double getSimplePnlPcnt() {
        return simplePnlPcnt;
    }

    public void setSimplePnlPcnt(Double simplePnlPcnt) {
        this.simplePnlPcnt = simplePnlPcnt;
    }

    public Position avgCostPrice(Double avgCostPrice) {
        this.avgCostPrice = avgCostPrice;
        return this;
    }

    /**
     * Get avgCostPrice
     * @return avgCostPrice
     **/
    @ApiModelProperty(value = "")
    public Double getAvgCostPrice() {
        return avgCostPrice;
    }

    public void setAvgCostPrice(Double avgCostPrice) {
        this.avgCostPrice = avgCostPrice;
    }

    public Position avgEntryPrice(Double avgEntryPrice) {
        this.avgEntryPrice = avgEntryPrice;
        return this;
    }

    /**
     * Get avgEntryPrice
     * @return avgEntryPrice
     **/
    @ApiModelProperty(value = "")
    public Double getAvgEntryPrice() {
        return avgEntryPrice;
    }

    public void setAvgEntryPrice(Double avgEntryPrice) {
        this.avgEntryPrice = avgEntryPrice;
    }

    public Position breakEvenPrice(Double breakEvenPrice) {
        this.breakEvenPrice = breakEvenPrice;
        return this;
    }

    /**
     * Get breakEvenPrice
     * @return breakEvenPrice
     **/
    @ApiModelProperty(value = "")
    public Double getBreakEvenPrice() {
        return breakEvenPrice;
    }

    public void setBreakEvenPrice(Double breakEvenPrice) {
        this.breakEvenPrice = breakEvenPrice;
    }

    public Position marginCallPrice(Double marginCallPrice) {
        this.marginCallPrice = marginCallPrice;
        return this;
    }

    /**
     * Get marginCallPrice
     * @return marginCallPrice
     **/
    @ApiModelProperty(value = "")
    public Double getMarginCallPrice() {
        return marginCallPrice;
    }

    public void setMarginCallPrice(Double marginCallPrice) {
        this.marginCallPrice = marginCallPrice;
    }

    public Position liquidationPrice(Double liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
        return this;
    }

    /**
     * Get liquidationPrice
     * @return liquidationPrice
     **/
    @ApiModelProperty(value = "")
    public Double getLiquidationPrice() {
        return liquidationPrice;
    }

    public void setLiquidationPrice(Double liquidationPrice) {
        this.liquidationPrice = liquidationPrice;
    }

    public Position bankruptPrice(Double bankruptPrice) {
        this.bankruptPrice = bankruptPrice;
        return this;
    }

    /**
     * Get bankruptPrice
     * @return bankruptPrice
     **/
    @ApiModelProperty(value = "")
    public Double getBankruptPrice() {
        return bankruptPrice;
    }

    public void setBankruptPrice(Double bankruptPrice) {
        this.bankruptPrice = bankruptPrice;
    }

    public Position timestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get timestamp
     * @return timestamp
     **/
    @ApiModelProperty(value = "")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Position lastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
        return this;
    }

    /**
     * Get lastPrice
     * @return lastPrice
     **/
    @ApiModelProperty(value = "")
    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Position lastValue(BigDecimal lastValue) {
        this.lastValue = lastValue;
        return this;
    }

    /**
     * Get lastValue
     * @return lastValue
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getLastValue() {
        return lastValue;
    }

    public void setLastValue(BigDecimal lastValue) {
        this.lastValue = lastValue;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return Objects.equals(this.account, position.account) &&
                Objects.equals(this.symbol, position.symbol) &&
                Objects.equals(this.currency, position.currency) &&
                Objects.equals(this.underlying, position.underlying) &&
                Objects.equals(this.quoteCurrency, position.quoteCurrency) &&
                Objects.equals(this.commission, position.commission) &&
                Objects.equals(this.initMarginReq, position.initMarginReq) &&
                Objects.equals(this.maintMarginReq, position.maintMarginReq) &&
                Objects.equals(this.riskLimit, position.riskLimit) &&
                Objects.equals(this.leverage, position.leverage) &&
                Objects.equals(this.crossMargin, position.crossMargin) &&
                Objects.equals(this.deleveragePercentile, position.deleveragePercentile) &&
                Objects.equals(this.rebalancedPnl, position.rebalancedPnl) &&
                Objects.equals(this.prevRealisedPnl, position.prevRealisedPnl) &&
                Objects.equals(this.prevUnrealisedPnl, position.prevUnrealisedPnl) &&
                Objects.equals(this.prevClosePrice, position.prevClosePrice) &&
                Objects.equals(this.openingTimestamp, position.openingTimestamp) &&
                Objects.equals(this.openingQty, position.openingQty) &&
                Objects.equals(this.openingCost, position.openingCost) &&
                Objects.equals(this.openingComm, position.openingComm) &&
                Objects.equals(this.openOrderBuyQty, position.openOrderBuyQty) &&
                Objects.equals(this.openOrderBuyCost, position.openOrderBuyCost) &&
                Objects.equals(this.openOrderBuyPremium, position.openOrderBuyPremium) &&
                Objects.equals(this.openOrderSellQty, position.openOrderSellQty) &&
                Objects.equals(this.openOrderSellCost, position.openOrderSellCost) &&
                Objects.equals(this.openOrderSellPremium, position.openOrderSellPremium) &&
                Objects.equals(this.execBuyQty, position.execBuyQty) &&
                Objects.equals(this.execBuyCost, position.execBuyCost) &&
                Objects.equals(this.execSellQty, position.execSellQty) &&
                Objects.equals(this.execSellCost, position.execSellCost) &&
                Objects.equals(this.execQty, position.execQty) &&
                Objects.equals(this.execCost, position.execCost) &&
                Objects.equals(this.execComm, position.execComm) &&
                Objects.equals(this.currentTimestamp, position.currentTimestamp) &&
                Objects.equals(this.currentQty, position.currentQty) &&
                Objects.equals(this.currentCost, position.currentCost) &&
                Objects.equals(this.currentComm, position.currentComm) &&
                Objects.equals(this.realisedCost, position.realisedCost) &&
                Objects.equals(this.unrealisedCost, position.unrealisedCost) &&
                Objects.equals(this.grossOpenCost, position.grossOpenCost) &&
                Objects.equals(this.grossOpenPremium, position.grossOpenPremium) &&
                Objects.equals(this.grossExecCost, position.grossExecCost) &&
                Objects.equals(this.isOpen, position.isOpen) &&
                Objects.equals(this.markPrice, position.markPrice) &&
                Objects.equals(this.markValue, position.markValue) &&
                Objects.equals(this.riskValue, position.riskValue) &&
                Objects.equals(this.homeNotional, position.homeNotional) &&
                Objects.equals(this.foreignNotional, position.foreignNotional) &&
                Objects.equals(this.posState, position.posState) &&
                Objects.equals(this.posCost, position.posCost) &&
                Objects.equals(this.posCost2, position.posCost2) &&
                Objects.equals(this.posCross, position.posCross) &&
                Objects.equals(this.posInit, position.posInit) &&
                Objects.equals(this.posComm, position.posComm) &&
                Objects.equals(this.posLoss, position.posLoss) &&
                Objects.equals(this.posMargin, position.posMargin) &&
                Objects.equals(this.posMaint, position.posMaint) &&
                Objects.equals(this.posAllowance, position.posAllowance) &&
                Objects.equals(this.taxableMargin, position.taxableMargin) &&
                Objects.equals(this.initMargin, position.initMargin) &&
                Objects.equals(this.maintMargin, position.maintMargin) &&
                Objects.equals(this.sessionMargin, position.sessionMargin) &&
                Objects.equals(this.targetExcessMargin, position.targetExcessMargin) &&
                Objects.equals(this.varMargin, position.varMargin) &&
                Objects.equals(this.realisedGrossPnl, position.realisedGrossPnl) &&
                Objects.equals(this.realisedTax, position.realisedTax) &&
                Objects.equals(this.realisedPnl, position.realisedPnl) &&
                Objects.equals(this.unrealisedGrossPnl, position.unrealisedGrossPnl) &&
                Objects.equals(this.longBankrupt, position.longBankrupt) &&
                Objects.equals(this.shortBankrupt, position.shortBankrupt) &&
                Objects.equals(this.taxBase, position.taxBase) &&
                Objects.equals(this.indicativeTaxRate, position.indicativeTaxRate) &&
                Objects.equals(this.indicativeTax, position.indicativeTax) &&
                Objects.equals(this.unrealisedTax, position.unrealisedTax) &&
                Objects.equals(this.unrealisedPnl, position.unrealisedPnl) &&
                Objects.equals(this.unrealisedPnlPcnt, position.unrealisedPnlPcnt) &&
                Objects.equals(this.unrealisedRoePcnt, position.unrealisedRoePcnt) &&
                Objects.equals(this.simpleQty, position.simpleQty) &&
                Objects.equals(this.simpleCost, position.simpleCost) &&
                Objects.equals(this.simpleValue, position.simpleValue) &&
                Objects.equals(this.simplePnl, position.simplePnl) &&
                Objects.equals(this.simplePnlPcnt, position.simplePnlPcnt) &&
                Objects.equals(this.avgCostPrice, position.avgCostPrice) &&
                Objects.equals(this.avgEntryPrice, position.avgEntryPrice) &&
                Objects.equals(this.breakEvenPrice, position.breakEvenPrice) &&
                Objects.equals(this.marginCallPrice, position.marginCallPrice) &&
                Objects.equals(this.liquidationPrice, position.liquidationPrice) &&
                Objects.equals(this.bankruptPrice, position.bankruptPrice) &&
                Objects.equals(this.timestamp, position.timestamp) &&
                Objects.equals(this.lastPrice, position.lastPrice) &&
                Objects.equals(this.lastValue, position.lastValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, symbol, currency, underlying, quoteCurrency, commission, initMarginReq, maintMarginReq, riskLimit, leverage, crossMargin, deleveragePercentile, rebalancedPnl, prevRealisedPnl, prevUnrealisedPnl, prevClosePrice, openingTimestamp, openingQty, openingCost, openingComm, openOrderBuyQty, openOrderBuyCost, openOrderBuyPremium, openOrderSellQty, openOrderSellCost, openOrderSellPremium, execBuyQty, execBuyCost, execSellQty, execSellCost, execQty, execCost, execComm, currentTimestamp, currentQty, currentCost, currentComm, realisedCost, unrealisedCost, grossOpenCost, grossOpenPremium, grossExecCost, isOpen, markPrice, markValue, riskValue, homeNotional, foreignNotional, posState, posCost, posCost2, posCross, posInit, posComm, posLoss, posMargin, posMaint, posAllowance, taxableMargin, initMargin, maintMargin, sessionMargin, targetExcessMargin, varMargin, realisedGrossPnl, realisedTax, realisedPnl, unrealisedGrossPnl, longBankrupt, shortBankrupt, taxBase, indicativeTaxRate, indicativeTax, unrealisedTax, unrealisedPnl, unrealisedPnlPcnt, unrealisedRoePcnt, simpleQty, simpleCost, simpleValue, simplePnl, simplePnlPcnt, avgCostPrice, avgEntryPrice, breakEvenPrice, marginCallPrice, liquidationPrice, bankruptPrice, timestamp, lastPrice, lastValue);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Position {\n");

        sb.append("    account: ").append(toIndentedString(account)).append("\n");
        sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    underlying: ").append(toIndentedString(underlying)).append("\n");
        sb.append("    quoteCurrency: ").append(toIndentedString(quoteCurrency)).append("\n");
        sb.append("    commission: ").append(toIndentedString(commission)).append("\n");
        sb.append("    initMarginReq: ").append(toIndentedString(initMarginReq)).append("\n");
        sb.append("    maintMarginReq: ").append(toIndentedString(maintMarginReq)).append("\n");
        sb.append("    riskLimit: ").append(toIndentedString(riskLimit)).append("\n");
        sb.append("    leverage: ").append(toIndentedString(leverage)).append("\n");
        sb.append("    crossMargin: ").append(toIndentedString(crossMargin)).append("\n");
        sb.append("    deleveragePercentile: ").append(toIndentedString(deleveragePercentile)).append("\n");
        sb.append("    rebalancedPnl: ").append(toIndentedString(rebalancedPnl)).append("\n");
        sb.append("    prevRealisedPnl: ").append(toIndentedString(prevRealisedPnl)).append("\n");
        sb.append("    prevUnrealisedPnl: ").append(toIndentedString(prevUnrealisedPnl)).append("\n");
        sb.append("    prevClosePrice: ").append(toIndentedString(prevClosePrice)).append("\n");
        sb.append("    openingTimestamp: ").append(toIndentedString(openingTimestamp)).append("\n");
        sb.append("    openingQty: ").append(toIndentedString(openingQty)).append("\n");
        sb.append("    openingCost: ").append(toIndentedString(openingCost)).append("\n");
        sb.append("    openingComm: ").append(toIndentedString(openingComm)).append("\n");
        sb.append("    openOrderBuyQty: ").append(toIndentedString(openOrderBuyQty)).append("\n");
        sb.append("    openOrderBuyCost: ").append(toIndentedString(openOrderBuyCost)).append("\n");
        sb.append("    openOrderBuyPremium: ").append(toIndentedString(openOrderBuyPremium)).append("\n");
        sb.append("    openOrderSellQty: ").append(toIndentedString(openOrderSellQty)).append("\n");
        sb.append("    openOrderSellCost: ").append(toIndentedString(openOrderSellCost)).append("\n");
        sb.append("    openOrderSellPremium: ").append(toIndentedString(openOrderSellPremium)).append("\n");
        sb.append("    execBuyQty: ").append(toIndentedString(execBuyQty)).append("\n");
        sb.append("    execBuyCost: ").append(toIndentedString(execBuyCost)).append("\n");
        sb.append("    execSellQty: ").append(toIndentedString(execSellQty)).append("\n");
        sb.append("    execSellCost: ").append(toIndentedString(execSellCost)).append("\n");
        sb.append("    execQty: ").append(toIndentedString(execQty)).append("\n");
        sb.append("    execCost: ").append(toIndentedString(execCost)).append("\n");
        sb.append("    execComm: ").append(toIndentedString(execComm)).append("\n");
        sb.append("    currentTimestamp: ").append(toIndentedString(currentTimestamp)).append("\n");
        sb.append("    currentQty: ").append(toIndentedString(currentQty)).append("\n");
        sb.append("    currentCost: ").append(toIndentedString(currentCost)).append("\n");
        sb.append("    currentComm: ").append(toIndentedString(currentComm)).append("\n");
        sb.append("    realisedCost: ").append(toIndentedString(realisedCost)).append("\n");
        sb.append("    unrealisedCost: ").append(toIndentedString(unrealisedCost)).append("\n");
        sb.append("    grossOpenCost: ").append(toIndentedString(grossOpenCost)).append("\n");
        sb.append("    grossOpenPremium: ").append(toIndentedString(grossOpenPremium)).append("\n");
        sb.append("    grossExecCost: ").append(toIndentedString(grossExecCost)).append("\n");
        sb.append("    isOpen: ").append(toIndentedString(isOpen)).append("\n");
        sb.append("    markPrice: ").append(toIndentedString(markPrice)).append("\n");
        sb.append("    markValue: ").append(toIndentedString(markValue)).append("\n");
        sb.append("    riskValue: ").append(toIndentedString(riskValue)).append("\n");
        sb.append("    homeNotional: ").append(toIndentedString(homeNotional)).append("\n");
        sb.append("    foreignNotional: ").append(toIndentedString(foreignNotional)).append("\n");
        sb.append("    posState: ").append(toIndentedString(posState)).append("\n");
        sb.append("    posCost: ").append(toIndentedString(posCost)).append("\n");
        sb.append("    posCost2: ").append(toIndentedString(posCost2)).append("\n");
        sb.append("    posCross: ").append(toIndentedString(posCross)).append("\n");
        sb.append("    posInit: ").append(toIndentedString(posInit)).append("\n");
        sb.append("    posComm: ").append(toIndentedString(posComm)).append("\n");
        sb.append("    posLoss: ").append(toIndentedString(posLoss)).append("\n");
        sb.append("    posMargin: ").append(toIndentedString(posMargin)).append("\n");
        sb.append("    posMaint: ").append(toIndentedString(posMaint)).append("\n");
        sb.append("    posAllowance: ").append(toIndentedString(posAllowance)).append("\n");
        sb.append("    taxableMargin: ").append(toIndentedString(taxableMargin)).append("\n");
        sb.append("    initMargin: ").append(toIndentedString(initMargin)).append("\n");
        sb.append("    maintMargin: ").append(toIndentedString(maintMargin)).append("\n");
        sb.append("    sessionMargin: ").append(toIndentedString(sessionMargin)).append("\n");
        sb.append("    targetExcessMargin: ").append(toIndentedString(targetExcessMargin)).append("\n");
        sb.append("    varMargin: ").append(toIndentedString(varMargin)).append("\n");
        sb.append("    realisedGrossPnl: ").append(toIndentedString(realisedGrossPnl)).append("\n");
        sb.append("    realisedTax: ").append(toIndentedString(realisedTax)).append("\n");
        sb.append("    realisedPnl: ").append(toIndentedString(realisedPnl)).append("\n");
        sb.append("    unrealisedGrossPnl: ").append(toIndentedString(unrealisedGrossPnl)).append("\n");
        sb.append("    longBankrupt: ").append(toIndentedString(longBankrupt)).append("\n");
        sb.append("    shortBankrupt: ").append(toIndentedString(shortBankrupt)).append("\n");
        sb.append("    taxBase: ").append(toIndentedString(taxBase)).append("\n");
        sb.append("    indicativeTaxRate: ").append(toIndentedString(indicativeTaxRate)).append("\n");
        sb.append("    indicativeTax: ").append(toIndentedString(indicativeTax)).append("\n");
        sb.append("    unrealisedTax: ").append(toIndentedString(unrealisedTax)).append("\n");
        sb.append("    unrealisedPnl: ").append(toIndentedString(unrealisedPnl)).append("\n");
        sb.append("    unrealisedPnlPcnt: ").append(toIndentedString(unrealisedPnlPcnt)).append("\n");
        sb.append("    unrealisedRoePcnt: ").append(toIndentedString(unrealisedRoePcnt)).append("\n");
        sb.append("    simpleQty: ").append(toIndentedString(simpleQty)).append("\n");
        sb.append("    simpleCost: ").append(toIndentedString(simpleCost)).append("\n");
        sb.append("    simpleValue: ").append(toIndentedString(simpleValue)).append("\n");
        sb.append("    simplePnl: ").append(toIndentedString(simplePnl)).append("\n");
        sb.append("    simplePnlPcnt: ").append(toIndentedString(simplePnlPcnt)).append("\n");
        sb.append("    avgCostPrice: ").append(toIndentedString(avgCostPrice)).append("\n");
        sb.append("    avgEntryPrice: ").append(toIndentedString(avgEntryPrice)).append("\n");
        sb.append("    breakEvenPrice: ").append(toIndentedString(breakEvenPrice)).append("\n");
        sb.append("    marginCallPrice: ").append(toIndentedString(marginCallPrice)).append("\n");
        sb.append("    liquidationPrice: ").append(toIndentedString(liquidationPrice)).append("\n");
        sb.append("    bankruptPrice: ").append(toIndentedString(bankruptPrice)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    lastPrice: ").append(toIndentedString(lastPrice)).append("\n");
        sb.append("    lastValue: ").append(toIndentedString(lastValue)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}


