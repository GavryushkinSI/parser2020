package ru.gavryushkin.parser.remoteAccess;

import ru.gavryushkin.parser.CustomWebHooksModule;
import ru.gavryushkin.parser.ParserApplication;
import ru.gavryushkin.parser.rest.JettyApplication;

public class RemoteAccess {

    private ParserApplication.Trade trade;
    private ParserApplication.Dialog dialog;
    private JettyApplication jettyApplication;
    private ParserApplication.WebHooksModule webHooksModule;
    private CustomWebHooksModule customWebHooksModule;

    public RemoteAccess(ParserApplication.Trade trade,
                        ParserApplication.Dialog dialog,
                        JettyApplication jettyApplication,
                        ParserApplication.WebHooksModule webHooksModule,
                        CustomWebHooksModule customWebHooksModule) {

        this.trade = trade;
        this.dialog = dialog;
        this.jettyApplication = jettyApplication;
        this.webHooksModule = webHooksModule;
        this.customWebHooksModule = customWebHooksModule;
    }

    public void startRemoteAccess() {
        if (jettyApplication == null) {
            jettyApplication = new JettyApplication(trade, dialog, webHooksModule, customWebHooksModule);
            jettyApplication.startServerJetty();
        }
    }
}
