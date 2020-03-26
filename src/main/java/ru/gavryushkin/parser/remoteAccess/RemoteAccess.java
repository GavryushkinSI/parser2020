package ru.gavryushkin.parser.remoteAccess;

import ru.gavryushkin.parser.ParserApplication;
import ru.gavryushkin.parser.rest.JettyApplication;

public class RemoteAccess {

    private ParserApplication.Trade trade;
    private ParserApplication.Dialog dialog;
    private JettyApplication jettyApplication;

    public RemoteAccess(ParserApplication.Trade trade,
                        ParserApplication.Dialog dialog,
                        JettyApplication jettyApplication) {

        this.trade = trade;
        this.dialog = dialog;
        this.jettyApplication = jettyApplication;
    }

    public void startRemoteAccess() {
        if (jettyApplication == null) {
            jettyApplication = new JettyApplication(trade,dialog);
            jettyApplication.startServerJetty();
        }
    }
}
