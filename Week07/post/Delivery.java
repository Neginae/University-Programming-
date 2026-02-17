class Delivery {

     private final Sendable[] sendables;

     Delivery(Sendable[] sendables) {
          if (sendables == null) {
               throw new NullPointerException();
          }
          for (Sendable sendable : sendables) {
               if (sendable == null) {
                    throw new NullPointerException();
               }
          }
          
          this.sendables = sendables.clone();
     }

     Delivery(Sendable sendable){
          if (sendable == null) {
               throw new NullPointerException();
          }
          this.sendables = new Sendable[] {sendable}; 
     }


     private static int postage(Sendable sendable) {
          int cost;

          if (sendable.weight() < 100) {
               cost = 1;
          }
          else {
               cost = 2;
          }


          if (!sendable.receiverLocation().country().equals(sendable.senderLocation().country())) {
               cost +=1;
          }

          return cost;
     }

     int postage() {
          int total = 0;
          for (Sendable sendable : sendables) {
               total += postage(sendable);
          }
          return total;
     }
}
