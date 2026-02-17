class Parcel implements Sendable {
     
     private final Location sender;
     private final Location receiver;
     private final double weight;

     Parcel(Location sender, Location receiver, double weight) {
          if (sender == null || receiver == null) {
               throw new NullPointerException();
          }
          this.sender = sender;
          this.receiver = receiver;
          this.weight = weight;
     }

     @Override
     public Location senderLocation() {
          return sender;
     }
     @Override
     public Location receiverLocation() {
          return receiver;
     }
     @Override 
     public double weight() {
          return weight;
     }
}
