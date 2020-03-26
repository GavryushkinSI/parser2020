package ru.gavryushkin.parser.bitmex.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Placement, Cancellation, Amending, and History
 */
@ApiModel(description = "Placement, Cancellation, Amending, and History")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-17T20:26:16.019-05:00")
public class Order {

    @SerializedName("orderID")
    private String orderID = null;

    @SerializedName("clOrdID")
    private String clOrdID = null;

    @SerializedName("clOrdLinkID")
    private String clOrdLinkID = null;

    @SerializedName("account")
    private BigDecimal account = null;

    @SerializedName("symbol")
    private String symbol = null;

    @SerializedName("side")
    private String side = null;

    @SerializedName("simpleOrderQty")
    private Double simpleOrderQty = null;

    @SerializedName("orderQty")
    private BigDecimal orderQty = null;

    @SerializedName("price")
    private Double price = null;

    @SerializedName("displayQty")
    private BigDecimal displayQty = null;

    @SerializedName("stopPx")
    private Double stopPx = null;

    @SerializedName("pegOffsetValue")
    private Double pegOffsetValue = null;

    @SerializedName("pegPriceType")
    private String pegPriceType = null;

    @SerializedName("currency")
    private String currency = null;

    @SerializedName("settlCurrency")
    private String settlCurrency = null;

    @SerializedName("ordType")
    private String ordType = null;

    @SerializedName("timeInForce")
    private String timeInForce = null;

    @SerializedName("execInst")
    private String execInst = null;

    @SerializedName("contingencyType")
    private String contingencyType = null;

    @SerializedName("exDestination")
    private String exDestination = null;

    @SerializedName("ordStatus")
    private String ordStatus = null;

    @SerializedName("triggered")
    private String triggered = null;

    @SerializedName("workingIndicator")
    private Boolean workingIndicator = null;

    @SerializedName("ordRejReason")
    private String ordRejReason = null;

    @SerializedName("simpleLeavesQty")
    private Double simpleLeavesQty = null;

    @SerializedName("leavesQty")
    private BigDecimal leavesQty = null;

    @SerializedName("simpleCumQty")
    private Double simpleCumQty = null;

    @SerializedName("cumQty")
    private BigDecimal cumQty = null;

    @SerializedName("avgPx")
    private Double avgPx = null;

    @SerializedName("multiLegReportingType")
    private String multiLegReportingType = null;

    @SerializedName("text")
    private String text = null;


    @SerializedName("transactTime")
    private String transactTime = null;

    @SerializedName("timestamp")
    private String timestamp = null;

    public Order orderID(String orderID) {
        this.orderID = orderID;
        return this;
    }

    /**
     * Get orderID
     * @return orderID
     **/
    @ApiModelProperty(required = true, value = "")
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Order clOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
        return this;
    }

    /**
     * Get clOrdID
     * @return clOrdID
     **/
    @ApiModelProperty(value = "")
    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }

    public Order clOrdLinkID(String clOrdLinkID) {
        this.clOrdLinkID = clOrdLinkID;
        return this;
    }

    /**
     * Get clOrdLinkID
     * @return clOrdLinkID
     **/
    @ApiModelProperty(value = "")
    public String getClOrdLinkID() {
        return clOrdLinkID;
    }

    public void setClOrdLinkID(String clOrdLinkID) {
        this.clOrdLinkID = clOrdLinkID;
    }

    public Order account(BigDecimal account) {
        this.account = account;
        return this;
    }

    /**
     * Get account
     * @return account
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public Order symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    /**
     * Get symbol
     * @return symbol
     **/
    @ApiModelProperty(value = "")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Order side(String side) {
        this.side = side;
        return this;
    }

    /**
     * Get side
     * @return side
     **/
    @ApiModelProperty(value = "")
    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Order simpleOrderQty(Double simpleOrderQty) {
        this.simpleOrderQty = simpleOrderQty;
        return this;
    }

    /**
     * Get simpleOrderQty
     * @return simpleOrderQty
     **/
    @ApiModelProperty(value = "")
    public Double getSimpleOrderQty() {
        return simpleOrderQty;
    }

    public void setSimpleOrderQty(Double simpleOrderQty) {
        this.simpleOrderQty = simpleOrderQty;
    }

    public Order orderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
        return this;
    }

    /**
     * Get orderQty
     * @return orderQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public Order price(Double price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     * @return price
     **/
    @ApiModelProperty(value = "")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order displayQty(BigDecimal displayQty) {
        this.displayQty = displayQty;
        return this;
    }

    /**
     * Get displayQty
     * @return displayQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getDisplayQty() {
        return displayQty;
    }

    public void setDisplayQty(BigDecimal displayQty) {
        this.displayQty = displayQty;
    }

    public Order stopPx(Double stopPx) {
        this.stopPx = stopPx;
        return this;
    }

    /**
     * Get stopPx
     * @return stopPx
     **/
    @ApiModelProperty(value = "")
    public Double getStopPx() {
        return stopPx;
    }

    public void setStopPx(Double stopPx) {
        this.stopPx = stopPx;
    }

    public Order pegOffsetValue(Double pegOffsetValue) {
        this.pegOffsetValue = pegOffsetValue;
        return this;
    }

    /**
     * Get pegOffsetValue
     * @return pegOffsetValue
     **/
    @ApiModelProperty(value = "")
    public Double getPegOffsetValue() {
        return pegOffsetValue;
    }

    public void setPegOffsetValue(Double pegOffsetValue) {
        this.pegOffsetValue = pegOffsetValue;
    }

    public Order pegPriceType(String pegPriceType) {
        this.pegPriceType = pegPriceType;
        return this;
    }

    /**
     * Get pegPriceType
     * @return pegPriceType
     **/
    @ApiModelProperty(value = "")
    public String getPegPriceType() {
        return pegPriceType;
    }

    public void setPegPriceType(String pegPriceType) {
        this.pegPriceType = pegPriceType;
    }

    public Order currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     * @return currency
     **/
    @ApiModelProperty(value = "")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Order settlCurrency(String settlCurrency) {
        this.settlCurrency = settlCurrency;
        return this;
    }

    /**
     * Get settlCurrency
     * @return settlCurrency
     **/
    @ApiModelProperty(value = "")
    public String getSettlCurrency() {
        return settlCurrency;
    }

    public void setSettlCurrency(String settlCurrency) {
        this.settlCurrency = settlCurrency;
    }

    public Order ordType(String ordType) {
        this.ordType = ordType;
        return this;
    }

    /**
     * Get ordType
     * @return ordType
     **/
    @ApiModelProperty(value = "")
    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public Order timeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
        return this;
    }

    /**
     * Get timeInForce
     * @return timeInForce
     **/
    @ApiModelProperty(value = "")
    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public Order execInst(String execInst) {
        this.execInst = execInst;
        return this;
    }

    /**
     * Get execInst
     * @return execInst
     **/
    @ApiModelProperty(value = "")
    public String getExecInst() {
        return execInst;
    }

    public void setExecInst(String execInst) {
        this.execInst = execInst;
    }

    public Order contingencyType(String contingencyType) {
        this.contingencyType = contingencyType;
        return this;
    }

    /**
     * Get contingencyType
     * @return contingencyType
     **/
    @ApiModelProperty(value = "")
    public String getContingencyType() {
        return contingencyType;
    }

    public void setContingencyType(String contingencyType) {
        this.contingencyType = contingencyType;
    }

    public Order exDestination(String exDestination) {
        this.exDestination = exDestination;
        return this;
    }

    /**
     * Get exDestination
     * @return exDestination
     **/
    @ApiModelProperty(value = "")
    public String getExDestination() {
        return exDestination;
    }

    public void setExDestination(String exDestination) {
        this.exDestination = exDestination;
    }

    public Order ordStatus(String ordStatus) {
        this.ordStatus = ordStatus;
        return this;
    }

    /**
     * Get ordStatus
     * @return ordStatus
     **/
    @ApiModelProperty(value = "")
    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    public Order triggered(String triggered) {
        this.triggered = triggered;
        return this;
    }

    /**
     * Get triggered
     * @return triggered
     **/
    @ApiModelProperty(value = "")
    public String getTriggered() {
        return triggered;
    }

    public void setTriggered(String triggered) {
        this.triggered = triggered;
    }

    public Order workingIndicator(Boolean workingIndicator) {
        this.workingIndicator = workingIndicator;
        return this;
    }

    /**
     * Get workingIndicator
     * @return workingIndicator
     **/
    @ApiModelProperty(value = "")
    public Boolean isWorkingIndicator() {
        return workingIndicator;
    }

    public void setWorkingIndicator(Boolean workingIndicator) {
        this.workingIndicator = workingIndicator;
    }

    public Order ordRejReason(String ordRejReason) {
        this.ordRejReason = ordRejReason;
        return this;
    }

    /**
     * Get ordRejReason
     * @return ordRejReason
     **/
    @ApiModelProperty(value = "")
    public String getOrdRejReason() {
        return ordRejReason;
    }

    public void setOrdRejReason(String ordRejReason) {
        this.ordRejReason = ordRejReason;
    }

    public Order simpleLeavesQty(Double simpleLeavesQty) {
        this.simpleLeavesQty = simpleLeavesQty;
        return this;
    }

    /**
     * Get simpleLeavesQty
     * @return simpleLeavesQty
     **/
    @ApiModelProperty(value = "")
    public Double getSimpleLeavesQty() {
        return simpleLeavesQty;
    }

    public void setSimpleLeavesQty(Double simpleLeavesQty) {
        this.simpleLeavesQty = simpleLeavesQty;
    }

    public Order leavesQty(BigDecimal leavesQty) {
        this.leavesQty = leavesQty;
        return this;
    }

    /**
     * Get leavesQty
     * @return leavesQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(BigDecimal leavesQty) {
        this.leavesQty = leavesQty;
    }

    public Order simpleCumQty(Double simpleCumQty) {
        this.simpleCumQty = simpleCumQty;
        return this;
    }

    /**
     * Get simpleCumQty
     * @return simpleCumQty
     **/
    @ApiModelProperty(value = "")
    public Double getSimpleCumQty() {
        return simpleCumQty;
    }

    public void setSimpleCumQty(Double simpleCumQty) {
        this.simpleCumQty = simpleCumQty;
    }

    public Order cumQty(BigDecimal cumQty) {
        this.cumQty = cumQty;
        return this;
    }

    /**
     * Get cumQty
     * @return cumQty
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getCumQty() {
        return cumQty;
    }

    public void setCumQty(BigDecimal cumQty) {
        this.cumQty = cumQty;
    }

    public Order avgPx(Double avgPx) {
        this.avgPx = avgPx;
        return this;
    }

    /**
     * Get avgPx
     * @return avgPx
     **/
    @ApiModelProperty(value = "")
    public Double getAvgPx() {
        return avgPx;
    }

    public void setAvgPx(Double avgPx) {
        this.avgPx = avgPx;
    }

    public Order multiLegReportingType(String multiLegReportingType) {
        this.multiLegReportingType = multiLegReportingType;
        return this;
    }

    /**
     * Get multiLegReportingType
     * @return multiLegReportingType
     **/
    @ApiModelProperty(value = "")
    public String getMultiLegReportingType() {
        return multiLegReportingType;
    }

    public void setMultiLegReportingType(String multiLegReportingType) {
        this.multiLegReportingType = multiLegReportingType;
    }

    public Order text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Get text
     * @return text
     **/
    @ApiModelProperty(value = "")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Order transactTime(String transactTime) {
        this.transactTime = transactTime;
        return this;
    }

    /**
     * Get transactTime
     * @return transactTime
     **/
    @ApiModelProperty(value = "")
    public String getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(String transactTime) {
        this.transactTime = transactTime;
    }

    public Order timestamp(String timestamp) {
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(this.orderID, order.orderID) &&
                Objects.equals(this.clOrdID, order.clOrdID) &&
                Objects.equals(this.clOrdLinkID, order.clOrdLinkID) &&
                Objects.equals(this.account, order.account) &&
                Objects.equals(this.symbol, order.symbol) &&
                Objects.equals(this.side, order.side) &&
                Objects.equals(this.simpleOrderQty, order.simpleOrderQty) &&
                Objects.equals(this.orderQty, order.orderQty) &&
                Objects.equals(this.price, order.price) &&
                Objects.equals(this.displayQty, order.displayQty) &&
                Objects.equals(this.stopPx, order.stopPx) &&
                Objects.equals(this.pegOffsetValue, order.pegOffsetValue) &&
                Objects.equals(this.pegPriceType, order.pegPriceType) &&
                Objects.equals(this.currency, order.currency) &&
                Objects.equals(this.settlCurrency, order.settlCurrency) &&
                Objects.equals(this.ordType, order.ordType) &&
                Objects.equals(this.timeInForce, order.timeInForce) &&
                Objects.equals(this.execInst, order.execInst) &&
                Objects.equals(this.contingencyType, order.contingencyType) &&
                Objects.equals(this.exDestination, order.exDestination) &&
                Objects.equals(this.ordStatus, order.ordStatus) &&
                Objects.equals(this.triggered, order.triggered) &&
                Objects.equals(this.workingIndicator, order.workingIndicator) &&
                Objects.equals(this.ordRejReason, order.ordRejReason) &&
                Objects.equals(this.simpleLeavesQty, order.simpleLeavesQty) &&
                Objects.equals(this.leavesQty, order.leavesQty) &&
                Objects.equals(this.simpleCumQty, order.simpleCumQty) &&
                Objects.equals(this.cumQty, order.cumQty) &&
                Objects.equals(this.avgPx, order.avgPx) &&
                Objects.equals(this.multiLegReportingType, order.multiLegReportingType) &&
                Objects.equals(this.text, order.text) &&
                Objects.equals(this.transactTime, order.transactTime) &&
                Objects.equals(this.timestamp, order.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, clOrdID, clOrdLinkID, account, symbol, side, simpleOrderQty, orderQty, price, displayQty, stopPx, pegOffsetValue, pegPriceType, currency, settlCurrency, ordType, timeInForce, execInst, contingencyType, exDestination, ordStatus, triggered, workingIndicator, ordRejReason, simpleLeavesQty, leavesQty, simpleCumQty, cumQty, avgPx, multiLegReportingType, text, transactTime, timestamp);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");

        sb.append("    orderID: ").append(toIndentedString(orderID)).append("\n");
        sb.append("    clOrdID: ").append(toIndentedString(clOrdID)).append("\n");
        sb.append("    clOrdLinkID: ").append(toIndentedString(clOrdLinkID)).append("\n");
        sb.append("    account: ").append(toIndentedString(account)).append("\n");
        sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
        sb.append("    side: ").append(toIndentedString(side)).append("\n");
        sb.append("    simpleOrderQty: ").append(toIndentedString(simpleOrderQty)).append("\n");
        sb.append("    orderQty: ").append(toIndentedString(orderQty)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    displayQty: ").append(toIndentedString(displayQty)).append("\n");
        sb.append("    stopPx: ").append(toIndentedString(stopPx)).append("\n");
        sb.append("    pegOffsetValue: ").append(toIndentedString(pegOffsetValue)).append("\n");
        sb.append("    pegPriceType: ").append(toIndentedString(pegPriceType)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    settlCurrency: ").append(toIndentedString(settlCurrency)).append("\n");
        sb.append("    ordType: ").append(toIndentedString(ordType)).append("\n");
        sb.append("    timeInForce: ").append(toIndentedString(timeInForce)).append("\n");
        sb.append("    execInst: ").append(toIndentedString(execInst)).append("\n");
        sb.append("    contingencyType: ").append(toIndentedString(contingencyType)).append("\n");
        sb.append("    exDestination: ").append(toIndentedString(exDestination)).append("\n");
        sb.append("    ordStatus: ").append(toIndentedString(ordStatus)).append("\n");
        sb.append("    triggered: ").append(toIndentedString(triggered)).append("\n");
        sb.append("    workingIndicator: ").append(toIndentedString(workingIndicator)).append("\n");
        sb.append("    ordRejReason: ").append(toIndentedString(ordRejReason)).append("\n");
        sb.append("    simpleLeavesQty: ").append(toIndentedString(simpleLeavesQty)).append("\n");
        sb.append("    leavesQty: ").append(toIndentedString(leavesQty)).append("\n");
        sb.append("    simpleCumQty: ").append(toIndentedString(simpleCumQty)).append("\n");
        sb.append("    cumQty: ").append(toIndentedString(cumQty)).append("\n");
        sb.append("    avgPx: ").append(toIndentedString(avgPx)).append("\n");
        sb.append("    multiLegReportingType: ").append(toIndentedString(multiLegReportingType)).append("\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
        sb.append("    transactTime: ").append(toIndentedString(transactTime)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
