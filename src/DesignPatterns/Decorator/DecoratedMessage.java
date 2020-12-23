package DesignPatterns.Decorator;

public abstract class DecoratedMessage extends Message{
        public DecoratedMessage(Message message){
            super(message);
        }
}
