class Letter implements Sendable {
     // 1. Fields that i need: weight is fixed
     private final Location sender;
     private final Location receiver;

     // 2. Constructor
     Letter(Location sender, Location receiver) {
          if (receiver == null || sender == null) {
               throw new NullPointerException();
          }
          this.sender = sender;
          this.receiver = receiver;
     }

     // 3. Methods
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
          return 80.0;
     }


}
