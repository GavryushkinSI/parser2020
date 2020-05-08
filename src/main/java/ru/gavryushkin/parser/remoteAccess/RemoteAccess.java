package ru.gavryushkin.parser.remoteAccess;

import ru.gavryushkin.parser.ParserApplication;
import ru.gavryushkin.parser.rest.JettyApplication;

public class RemoteAccess {

    private ParserApplication.Trade trade;
    private ParserApplication.Dialog dialog;
    private JettyApplication jettyApplication;
    private ParserApplication.WebHooksModule webHooksModule;

    public RemoteAccess(ParserApplication.Trade trade,
                        ParserApplication.Dialog dialog,
                        JettyApplication jettyApplication,
                        ParserApplication.WebHooksModule webHooksModule) {

        this.trade = trade;
        this.dialog = dialog;
        this.jettyApplication = jettyApplication;
        this.webHooksModule = webHooksModule;
    }

    public void startRemoteAccess() {
        if (jettyApplication == null) {
            jettyApplication = new JettyApplication(trade, dialog, webHooksModule);
            jettyApplication.startServerJetty();
        }
    }
}
