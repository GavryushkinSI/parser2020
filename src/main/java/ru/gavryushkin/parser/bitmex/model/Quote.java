package ru.gavryushkin.parser.bitmex.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Best Bid/Offer Snapshots &amp; Historical Bins
 */
@ApiModel(description = "Best Bid/Offer Snapshots & Historical Bins")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-17T20:26:16.019-05:00")
public class Quote {
    @SerializedName("timestamp")
    private OffsetDateTime timestamp = null;

    @SerializedName("symbol")
    private String symbol = null;

    @SerializedName("bidSize")
    private BigDecimal bidSize = null;

    @SerializedName("bidPrice")
    private Double bidPrice = null;

    @SerializedName("askPrice")
    private Double askPrice = null;

    @SerializedName("askSize")
    private BigDecimal askSize = null;

    public Quote timestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get timestamp
     * @return timestamp
     **/
    @ApiModelProperty(required = true, value = "")
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Quote symbol(String symbol) {
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

    public Quote bidSize(BigDecimal bidSize) {
        this.bidSize = bidSize;
        return this;
    }

    /**
     * Get bidSize
     * @return bidSize
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getBidSize() {
        return bidSize;
    }

    public void setBidSize(BigDecimal bidSize) {
        this.bidSize = bidSize;
    }

    public Quote bidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
        return this;
    }

    /**
     * Get bidPrice
     * @return bidPrice
     **/
    @ApiModelProperty(value = "")
    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Quote askPrice(Double askPrice) {
        this.askPrice = askPrice;
        return this;
    }

    /**
     * Get askPrice
     * @return askPrice
     **/
    @ApiModelProperty(value = "")
    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public Quote askSize(BigDecimal askSize) {
        this.askSize = askSize;
        return this;
    }

    /**
     * Get askSize
     * @return askSize
     **/
    @ApiModelProperty(value = "")
    public BigDecimal getAskSize() {
        return askSize;
    }

    public void setAskSize(BigDecimal askSize) {
        this.askSize = askSize;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Quote quote = (Quote) o;
        return Objects.equals(this.timestamp, quote.timestamp) &&
                Objects.equals(this.symbol, quote.symbol) &&
                Objects.equals(this.bidSize, quote.bidSize) &&
                Objects.equals(this.bidPrice, quote.bidPrice) &&
                Objects.equals(this.askPrice, quote.askPrice) &&
                Objects.equals(this.askSize, quote.askSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, symbol, bidSize, bidPrice, askPrice, askSize);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Quote {\n");

        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
        sb.append("    bidSize: ").append(toIndentedString(bidSize)).append("\n");
        sb.append("    bidPrice: ").append(toIndentedString(bidPrice)).append("\n");
        sb.append("    askPrice: ").append(toIndentedString(askPrice)).append("\n");
        sb.append("    askSize: ").append(toIndentedString(askSize)).append("\n");
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



