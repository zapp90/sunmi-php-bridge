public class HTTPServer extends NanoHTTPD {
    public HTTPServer() {
        super(9999);
    }

    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();
        Map<String, String> params = session.getParms();

        if (uri.equals("/print")) {
            String text = params.get("text");
            SunmiPrinter.getInstance().printText(text + "\n");
            return newFixedLengthResponse("Printed: " + text);
        }

        if (uri.equals("/status")) {
            return newFixedLengthResponse("Printer OK");
        }

        return newFixedLengthResponse("Unknown Command");
    }
}
