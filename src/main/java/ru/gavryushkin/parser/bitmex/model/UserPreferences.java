package ru.gavryushkin.parser.bitmex.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserPreferences
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-17T20:26:16.019-05:00")
public class UserPreferences {
    @SerializedName("alertOnLiquidations")
    private Boolean alertOnLiquidations = null;

    @SerializedName("animationsEnabled")
    private Boolean animationsEnabled = null;

    @SerializedName("announcementsLastSeen")
    private String announcementsLastSeen = null;

    @SerializedName("chatChannelID")
    private Double chatChannelID = null;

    @SerializedName("colorTheme")
    private String colorTheme = null;

    @SerializedName("currency")
    private String currency = null;

    @SerializedName("debug")
    private Boolean debug = null;

    @SerializedName("disableEmails")
    private List<String> disableEmails = null;

    @SerializedName("disablePush")
    private List<String> disablePush = null;

    @SerializedName("hideConfirmDialogs")
    private List<String> hideConfirmDialogs = null;

    @SerializedName("hideConnectionModal")
    private Boolean hideConnectionModal = null;

    @SerializedName("hideFromLeaderboard")
    private Boolean hideFromLeaderboard = false;

    @SerializedName("hideNameFromLeaderboard")
    private Boolean hideNameFromLeaderboard = true;

    @SerializedName("hideNotifications")
    private List<String> hideNotifications = null;

    @SerializedName("locale")
    private String locale = "en-US";

    @SerializedName("msgsSeen")
    private List<String> msgsSeen = null;

    @SerializedName("orderBookBinning")
    private Object orderBookBinning = null;

    @SerializedName("orderBookType")
    private String orderBookType = null;

    @SerializedName("orderClearImmediate")
    private Boolean orderClearImmediate = false;

    @SerializedName("orderControlsPlusMinus")
    private Boolean orderControlsPlusMinus = null;

    @SerializedName("showLocaleNumbers")
    private Boolean showLocaleNumbers = true;

    @SerializedName("sounds")
    private List<String> sounds = null;

    @SerializedName("strictIPCheck")
    private Boolean strictIPCheck = false;

    @SerializedName("strictTimeout")
    private Boolean strictTimeout = true;

    @SerializedName("tickerGroup")
    private String tickerGroup = null;

    @SerializedName("tickerPinned")
    private Boolean tickerPinned = null;

    @SerializedName("tradeLayout")
    private String tradeLayout = null;

    public UserPreferences alertOnLiquidations(Boolean alertOnLiquidations) {
        this.alertOnLiquidations = alertOnLiquidations;
        return this;
    }

    /**
     * Get alertOnLiquidations
     * @return alertOnLiquidations
     **/
    @ApiModelProperty(value = "")
    public Boolean isAlertOnLiquidations() {
        return alertOnLiquidations;
    }

    public void setAlertOnLiquidations(Boolean alertOnLiquidations) {
        this.alertOnLiquidations = alertOnLiquidations;
    }

    public UserPreferences animationsEnabled(Boolean animationsEnabled) {
        this.animationsEnabled = animationsEnabled;
        return this;
    }

    /**
     * Get animationsEnabled
     * @return animationsEnabled
     **/
    @ApiModelProperty(value = "")
    public Boolean isAnimationsEnabled() {
        return animationsEnabled;
    }

    public void setAnimationsEnabled(Boolean animationsEnabled) {
        this.animationsEnabled = animationsEnabled;
    }

    public UserPreferences announcementsLastSeen(String announcementsLastSeen) {
        this.announcementsLastSeen = announcementsLastSeen;
        return this;
    }

    /**
     * Get announcementsLastSeen
     * @return announcementsLastSeen
     **/
    @ApiModelProperty(value = "")
    public String getAnnouncementsLastSeen() {
        return announcementsLastSeen;
    }

    public void setAnnouncementsLastSeen(String announcementsLastSeen) {
        this.announcementsLastSeen = announcementsLastSeen;
    }

    public UserPreferences chatChannelID(Double chatChannelID) {
        this.chatChannelID = chatChannelID;
        return this;
    }

    /**
     * Get chatChannelID
     * @return chatChannelID
     **/
    @ApiModelProperty(value = "")
    public Double getChatChannelID() {
        return chatChannelID;
    }

    public void setChatChannelID(Double chatChannelID) {
        this.chatChannelID = chatChannelID;
    }

    public UserPreferences colorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
        return this;
    }

    /**
     * Get colorTheme
     * @return colorTheme
     **/
    @ApiModelProperty(value = "")
    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
    }

    public UserPreferences currency(String currency) {
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

    public UserPreferences debug(Boolean debug) {
        this.debug = debug;
        return this;
    }

    /**
     * Get debug
     * @return debug
     **/
    @ApiModelProperty(value = "")
    public Boolean isDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public UserPreferences disableEmails(List<String> disableEmails) {
        this.disableEmails = disableEmails;
        return this;
    }

    public UserPreferences addDisableEmailsItem(String disableEmailsItem) {
        if (this.disableEmails == null) {
            this.disableEmails = new ArrayList<String>();
        }
        this.disableEmails.add(disableEmailsItem);
        return this;
    }

    /**
     * Get disableEmails
     * @return disableEmails
     **/
    @ApiModelProperty(value = "")
    public List<String> getDisableEmails() {
        return disableEmails;
    }

    public void setDisableEmails(List<String> disableEmails) {
        this.disableEmails = disableEmails;
    }

    public UserPreferences disablePush(List<String> disablePush) {
        this.disablePush = disablePush;
        return this;
    }

    public UserPreferences addDisablePushItem(String disablePushItem) {
        if (this.disablePush == null) {
            this.disablePush = new ArrayList<String>();
        }
        this.disablePush.add(disablePushItem);
        return this;
    }

    /**
     * Get disablePush
     * @return disablePush
     **/
    @ApiModelProperty(value = "")
    public List<String> getDisablePush() {
        return disablePush;
    }

    public void setDisablePush(List<String> disablePush) {
        this.disablePush = disablePush;
    }

    public UserPreferences hideConfirmDialogs(List<String> hideConfirmDialogs) {
        this.hideConfirmDialogs = hideConfirmDialogs;
        return this;
    }

    public UserPreferences addHideConfirmDialogsItem(String hideConfirmDialogsItem) {
        if (this.hideConfirmDialogs == null) {
            this.hideConfirmDialogs = new ArrayList<String>();
        }
        this.hideConfirmDialogs.add(hideConfirmDialogsItem);
        return this;
    }

    /**
     * Get hideConfirmDialogs
     * @return hideConfirmDialogs
     **/
    @ApiModelProperty(value = "")
    public List<String> getHideConfirmDialogs() {
        return hideConfirmDialogs;
    }

    public void setHideConfirmDialogs(List<String> hideConfirmDialogs) {
        this.hideConfirmDialogs = hideConfirmDialogs;
    }

    public UserPreferences hideConnectionModal(Boolean hideConnectionModal) {
        this.hideConnectionModal = hideConnectionModal;
        return this;
    }

    /**
     * Get hideConnectionModal
     * @return hideConnectionModal
     **/
    @ApiModelProperty(value = "")
    public Boolean isHideConnectionModal() {
        return hideConnectionModal;
    }

    public void setHideConnectionModal(Boolean hideConnectionModal) {
        this.hideConnectionModal = hideConnectionModal;
    }

    public UserPreferences hideFromLeaderboard(Boolean hideFromLeaderboard) {
        this.hideFromLeaderboard = hideFromLeaderboard;
        return this;
    }

    /**
     * Get hideFromLeaderboard
     * @return hideFromLeaderboard
     **/
    @ApiModelProperty(value = "")
    public Boolean isHideFromLeaderboard() {
        return hideFromLeaderboard;
    }

    public void setHideFromLeaderboard(Boolean hideFromLeaderboard) {
        this.hideFromLeaderboard = hideFromLeaderboard;
    }

    public UserPreferences hideNameFromLeaderboard(Boolean hideNameFromLeaderboard) {
        this.hideNameFromLeaderboard = hideNameFromLeaderboard;
        return this;
    }

    /**
     * Get hideNameFromLeaderboard
     * @return hideNameFromLeaderboard
     **/
    @ApiModelProperty(value = "")
    public Boolean isHideNameFromLeaderboard() {
        return hideNameFromLeaderboard;
    }

    public void setHideNameFromLeaderboard(Boolean hideNameFromLeaderboard) {
        this.hideNameFromLeaderboard = hideNameFromLeaderboard;
    }

    public UserPreferences hideNotifications(List<String> hideNotifications) {
        this.hideNotifications = hideNotifications;
        return this;
    }

    public UserPreferences addHideNotificationsItem(String hideNotificationsItem) {
        if (this.hideNotifications == null) {
            this.hideNotifications = new ArrayList<String>();
        }
        this.hideNotifications.add(hideNotificationsItem);
        return this;
    }

    /**
     * Get hideNotifications
     * @return hideNotifications
     **/
    @ApiModelProperty(value = "")
    public List<String> getHideNotifications() {
        return hideNotifications;
    }

    public void setHideNotifications(List<String> hideNotifications) {
        this.hideNotifications = hideNotifications;
    }

    public UserPreferences locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * Get locale
     * @return locale
     **/
    @ApiModelProperty(value = "")
    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public UserPreferences msgsSeen(List<String> msgsSeen) {
        this.msgsSeen = msgsSeen;
        return this;
    }

    public UserPreferences addMsgsSeenItem(String msgsSeenItem) {
        if (this.msgsSeen == null) {
            this.msgsSeen = new ArrayList<String>();
        }
        this.msgsSeen.add(msgsSeenItem);
        return this;
    }

    /**
     * Get msgsSeen
     * @return msgsSeen
     **/
    @ApiModelProperty(value = "")
    public List<String> getMsgsSeen() {
        return msgsSeen;
    }

    public void setMsgsSeen(List<String> msgsSeen) {
        this.msgsSeen = msgsSeen;
    }

    public UserPreferences orderBookBinning(Object orderBookBinning) {
        this.orderBookBinning = orderBookBinning;
        return this;
    }

    /**
     * Get orderBookBinning
     * @return orderBookBinning
     **/
    @ApiModelProperty(value = "")
    public Object getOrderBookBinning() {
        return orderBookBinning;
    }

    public void setOrderBookBinning(Object orderBookBinning) {
        this.orderBookBinning = orderBookBinning;
    }

    public UserPreferences orderBookType(String orderBookType) {
        this.orderBookType = orderBookType;
        return this;
    }

    /**
     * Get orderBookType
     * @return orderBookType
     **/
    @ApiModelProperty(value = "")
    public String getOrderBookType() {
        return orderBookType;
    }

    public void setOrderBookType(String orderBookType) {
        this.orderBookType = orderBookType;
    }

    public UserPreferences orderClearImmediate(Boolean orderClearImmediate) {
        this.orderClearImmediate = orderClearImmediate;
        return this;
    }

    /**
     * Get orderClearImmediate
     * @return orderClearImmediate
     **/
    @ApiModelProperty(value = "")
    public Boolean isOrderClearImmediate() {
        return orderClearImmediate;
    }

    public void setOrderClearImmediate(Boolean orderClearImmediate) {
        this.orderClearImmediate = orderClearImmediate;
    }

    public UserPreferences orderControlsPlusMinus(Boolean orderControlsPlusMinus) {
        this.orderControlsPlusMinus = orderControlsPlusMinus;
        return this;
    }

    /**
     * Get orderControlsPlusMinus
     * @return orderControlsPlusMinus
     **/
    @ApiModelProperty(value = "")
    public Boolean isOrderControlsPlusMinus() {
        return orderControlsPlusMinus;
    }

    public void setOrderControlsPlusMinus(Boolean orderControlsPlusMinus) {
        this.orderControlsPlusMinus = orderControlsPlusMinus;
    }

    public UserPreferences showLocaleNumbers(Boolean showLocaleNumbers) {
        this.showLocaleNumbers = showLocaleNumbers;
        return this;
    }

    /**
     * Get showLocaleNumbers
     * @return showLocaleNumbers
     **/
    @ApiModelProperty(value = "")
    public Boolean isShowLocaleNumbers() {
        return showLocaleNumbers;
    }

    public void setShowLocaleNumbers(Boolean showLocaleNumbers) {
        this.showLocaleNumbers = showLocaleNumbers;
    }

    public UserPreferences sounds(List<String> sounds) {
        this.sounds = sounds;
        return this;
    }

    public UserPreferences addSoundsItem(String soundsItem) {
        if (this.sounds == null) {
            this.sounds = new ArrayList<String>();
        }
        this.sounds.add(soundsItem);
        return this;
    }

    /**
     * Get sounds
     * @return sounds
     **/
    @ApiModelProperty(value = "")
    public List<String> getSounds() {
        return sounds;
    }

    public void setSounds(List<String> sounds) {
        this.sounds = sounds;
    }

    public UserPreferences strictIPCheck(Boolean strictIPCheck) {
        this.strictIPCheck = strictIPCheck;
        return this;
    }

    /**
     * Get strictIPCheck
     * @return strictIPCheck
     **/
    @ApiModelProperty(value = "")
    public Boolean isStrictIPCheck() {
        return strictIPCheck;
    }

    public void setStrictIPCheck(Boolean strictIPCheck) {
        this.strictIPCheck = strictIPCheck;
    }

    public UserPreferences strictTimeout(Boolean strictTimeout) {
        this.strictTimeout = strictTimeout;
        return this;
    }

    /**
     * Get strictTimeout
     * @return strictTimeout
     **/
    @ApiModelProperty(value = "")
    public Boolean isStrictTimeout() {
        return strictTimeout;
    }

    public void setStrictTimeout(Boolean strictTimeout) {
        this.strictTimeout = strictTimeout;
    }

    public UserPreferences tickerGroup(String tickerGroup) {
        this.tickerGroup = tickerGroup;
        return this;
    }

    /**
     * Get tickerGroup
     * @return tickerGroup
     **/
    @ApiModelProperty(value = "")
    public String getTickerGroup() {
        return tickerGroup;
    }

    public void setTickerGroup(String tickerGroup) {
        this.tickerGroup = tickerGroup;
    }

    public UserPreferences tickerPinned(Boolean tickerPinned) {
        this.tickerPinned = tickerPinned;
        return this;
    }

    /**
     * Get tickerPinned
     * @return tickerPinned
     **/
    @ApiModelProperty(value = "")
    public Boolean isTickerPinned() {
        return tickerPinned;
    }

    public void setTickerPinned(Boolean tickerPinned) {
        this.tickerPinned = tickerPinned;
    }

    public UserPreferences tradeLayout(String tradeLayout) {
        this.tradeLayout = tradeLayout;
        return this;
    }

    /**
     * Get tradeLayout
     * @return tradeLayout
     **/
    @ApiModelProperty(value = "")
    public String getTradeLayout() {
        return tradeLayout;
    }

    public void setTradeLayout(String tradeLayout) {
        this.tradeLayout = tradeLayout;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPreferences userPreferences = (UserPreferences) o;
        return Objects.equals(this.alertOnLiquidations, userPreferences.alertOnLiquidations) &&
                Objects.equals(this.animationsEnabled, userPreferences.animationsEnabled) &&
                Objects.equals(this.announcementsLastSeen, userPreferences.announcementsLastSeen) &&
                Objects.equals(this.chatChannelID, userPreferences.chatChannelID) &&
                Objects.equals(this.colorTheme, userPreferences.colorTheme) &&
                Objects.equals(this.currency, userPreferences.currency) &&
                Objects.equals(this.debug, userPreferences.debug) &&
                Objects.equals(this.disableEmails, userPreferences.disableEmails) &&
                Objects.equals(this.disablePush, userPreferences.disablePush) &&
                Objects.equals(this.hideConfirmDialogs, userPreferences.hideConfirmDialogs) &&
                Objects.equals(this.hideConnectionModal, userPreferences.hideConnectionModal) &&
                Objects.equals(this.hideFromLeaderboard, userPreferences.hideFromLeaderboard) &&
                Objects.equals(this.hideNameFromLeaderboard, userPreferences.hideNameFromLeaderboard) &&
                Objects.equals(this.hideNotifications, userPreferences.hideNotifications) &&
                Objects.equals(this.locale, userPreferences.locale) &&
                Objects.equals(this.msgsSeen, userPreferences.msgsSeen) &&
                Objects.equals(this.orderBookBinning, userPreferences.orderBookBinning) &&
                Objects.equals(this.orderBookType, userPreferences.orderBookType) &&
                Objects.equals(this.orderClearImmediate, userPreferences.orderClearImmediate) &&
                Objects.equals(this.orderControlsPlusMinus, userPreferences.orderControlsPlusMinus) &&
                Objects.equals(this.showLocaleNumbers, userPreferences.showLocaleNumbers) &&
                Objects.equals(this.sounds, userPreferences.sounds) &&
                Objects.equals(this.strictIPCheck, userPreferences.strictIPCheck) &&
                Objects.equals(this.strictTimeout, userPreferences.strictTimeout) &&
                Objects.equals(this.tickerGroup, userPreferences.tickerGroup) &&
                Objects.equals(this.tickerPinned, userPreferences.tickerPinned) &&
                Objects.equals(this.tradeLayout, userPreferences.tradeLayout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alertOnLiquidations, animationsEnabled, announcementsLastSeen, chatChannelID, colorTheme, currency, debug, disableEmails, disablePush, hideConfirmDialogs, hideConnectionModal, hideFromLeaderboard, hideNameFromLeaderboard, hideNotifications, locale, msgsSeen, orderBookBinning, orderBookType, orderClearImmediate, orderControlsPlusMinus, showLocaleNumbers, sounds, strictIPCheck, strictTimeout, tickerGroup, tickerPinned, tradeLayout);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserPreferences {\n");

        sb.append("    alertOnLiquidations: ").append(toIndentedString(alertOnLiquidations)).append("\n");
        sb.append("    animationsEnabled: ").append(toIndentedString(animationsEnabled)).append("\n");
        sb.append("    announcementsLastSeen: ").append(toIndentedString(announcementsLastSeen)).append("\n");
        sb.append("    chatChannelID: ").append(toIndentedString(chatChannelID)).append("\n");
        sb.append("    colorTheme: ").append(toIndentedString(colorTheme)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    debug: ").append(toIndentedString(debug)).append("\n");
        sb.append("    disableEmails: ").append(toIndentedString(disableEmails)).append("\n");
        sb.append("    disablePush: ").append(toIndentedString(disablePush)).append("\n");
        sb.append("    hideConfirmDialogs: ").append(toIndentedString(hideConfirmDialogs)).append("\n");
        sb.append("    hideConnectionModal: ").append(toIndentedString(hideConnectionModal)).append("\n");
        sb.append("    hideFromLeaderboard: ").append(toIndentedString(hideFromLeaderboard)).append("\n");
        sb.append("    hideNameFromLeaderboard: ").append(toIndentedString(hideNameFromLeaderboard)).append("\n");
        sb.append("    hideNotifications: ").append(toIndentedString(hideNotifications)).append("\n");
        sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
        sb.append("    msgsSeen: ").append(toIndentedString(msgsSeen)).append("\n");
        sb.append("    orderBookBinning: ").append(toIndentedString(orderBookBinning)).append("\n");
        sb.append("    orderBookType: ").append(toIndentedString(orderBookType)).append("\n");
        sb.append("    orderClearImmediate: ").append(toIndentedString(orderClearImmediate)).append("\n");
        sb.append("    orderControlsPlusMinus: ").append(toIndentedString(orderControlsPlusMinus)).append("\n");
        sb.append("    showLocaleNumbers: ").append(toIndentedString(showLocaleNumbers)).append("\n");
        sb.append("    sounds: ").append(toIndentedString(sounds)).append("\n");
        sb.append("    strictIPCheck: ").append(toIndentedString(strictIPCheck)).append("\n");
        sb.append("    strictTimeout: ").append(toIndentedString(strictTimeout)).append("\n");
        sb.append("    tickerGroup: ").append(toIndentedString(tickerGroup)).append("\n");
        sb.append("    tickerPinned: ").append(toIndentedString(tickerPinned)).append("\n");
        sb.append("    tradeLayout: ").append(toIndentedString(tradeLayout)).append("\n");
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
