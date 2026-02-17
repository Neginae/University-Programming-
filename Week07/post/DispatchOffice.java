class DispatchOffice {
    static void main() {
        Letter letter = new Letter(new Location(40225, "Germany"),
                                    new Location(40530, "Sweden"));
        Delivery delivery = new Delivery(letter);
        System.out.println(delivery.postage());



        // Letter letter1 = new Letter(new Location(40225, "Germany"),
        //                             new Location(40530, "Sweden"));

        // Parcel parcel1 = new Parcel(new Location(40224, "Germany"),     
        //                             new Location(40225, "Germany"), 
        //                             70);

        // Sendable[] items = {letter1, parcel1};
        // Delivery delivery1 = new Delivery(items);
        // System.out.println(delivery1.postage());

        
    }
}
