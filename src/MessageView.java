public class MessageView {
    private Message m;
    private boolean angry;
    private boolean binary;
    private boolean encrypted;
    private boolean sms;
    public static final int ANGRY = 1;
    public static final int BINARY = 2;
    public static final int ENCRYPTED = 3;
    public static final int SMS = 4;

    public void setMessage(String s) {
        m = new Message(s);
    }

    public void toggle(int state) {
        switch(state) {
            case ANGRY:
                angry = !angry;
                break;
            case BINARY:
                binary = !binary;
                break;
            case ENCRYPTED:
                encrypted = !encrypted;
                break;
            case SMS:
                sms = !sms;
                break;
        }
    }

    public Message getMessage() {
        Message decoratedMessage = m;
        if (angry) {
            decoratedMessage = new AngryMessageDecorator(decoratedMessage);
        }
        if (binary) {
            decoratedMessage = new BinaryMessageDecorator(decoratedMessage);
        }
        if (encrypted) {
            decoratedMessage = new EncryptedMessageDecorator(decoratedMessage);
        }
        if (sms) {
            decoratedMessage = new SmsMessageDecorator(decoratedMessage);
        }
        return decoratedMessage;
    }
}


