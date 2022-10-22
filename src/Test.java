public class Test {
    public static void main(String[] args) {


//        Bed bed3=new Bed(3,"manual", "Bed Rails,Bedside Commodes");
//        Bed bed4=new Bed(4,"manual", "Headboard and Footboard Covers");
//        Bed bed5=new Bed(5,"semi-electric", " OverBed Table");

        Bed bed011=new Bed(1,"manual", "Bed Rails");
        Bed bed012=new Bed(2,"electric", " OverBed Table");
        Room room01=new Room(1,0,"Delivery room","7-9",new Bed[]{bed011,bed012});

        Bed bed021=new Bed(2,"electric", " none");
        Room room02=new Room(2,0,"Consulting room","7-9",new Bed[]{bed021});

//        create beds and change bed array
        Room room03=new Room(3,0,"Ward","7-9",new Bed[]{bed1,bed2});

        //        create beds and change bed array
        Room room04=new Room(4,0,"Maternity Ward","7-9",new Bed[]{bed1,bed2});

        //        create beds and change bed array
        Room room05=new Room(5,0,"Nursery","7-9",new Bed[]{bed1,bed2});

        //        create beds and change bed array
        Room room06=new Room(6,0,"Day Care","7-9",new Bed[]{bed1,bed2});

//        create beds and change bed array
        Room room11=new Room(1,0,"ICU","7-9",new Bed[]{bed1,bed2});
        //        create beds and change bed array  do for each room till line no 39
        Room room12=new Room(2,0,"operating theater","7-9",new Bed[]{bed1,bed2});
        Room room13=new Room(3,0,"Private ward","7-9",new Bed[]{bed1,bed2});
        Room room14=new Room(4,0,"Private Ward","7-9",new Bed[]{bed1,bed2});
        Room room15=new Room(5,0,"Emergency room","7-9",new Bed[]{bed1,bed2});

        Room room21=new Room(6,0,"ICU","7-9",new Bed[]{bed1,bed2});
        Room room22=new Room(4,0,"Ward","7-9",new Bed[]{bed1,bed2});
        Room room23=new Room(5,0,"padded cell","7-9",new Bed[]{bed1,bed2});
        Room room24=new Room(6,0,"Rehab Room","7-9",new Bed[]{bed1,bed2});


    }
}
