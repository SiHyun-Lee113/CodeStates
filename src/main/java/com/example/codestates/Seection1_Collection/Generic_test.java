package com.example.codestates.Seection1_Collection;

public class Generic_test {
    static class Phone {}

    static class IPhone extends Phone {}
    static class Galaxy extends Phone {}

    static class IPhone12Pro extends IPhone {}
    static class IPhoneX5 extends IPhone {}

    static class S22 extends Galaxy {}
    static class ZFlip3 extends Galaxy {}

    static class User<T> {
        public T phone;

        public User(T phone) {
            this.phone = phone;
        }
    }

    static class PhoneFunction {
        public static void call(User<? extends Phone> user) {
            System.out.println("-".repeat(60));
            System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
            System.out.println("모든 Phone은 통화를 할 수 있습니다.");
        }
        public static void faceId(User<? extends  IPhone> user) {
            System.out.println("-".repeat(60));
            System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
            System.out.println("Only IPhone users could use Face Id");
        }
        public static void samsungPay(User<? extends  Galaxy> user) {
            System.out.println("-".repeat(60));
            System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
            System.out.println("Only Galaxy users could use Samsung Pay");
        }
        public static void recordVoice(User<? super  Galaxy> user) {
            System.out.println("-".repeat(60));
            System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
            System.out.println("Only Android users could use Voice Record");
        }
    }

    public static void main(String[] args) {
        PhoneFunction.call(new User<Phone>(new Phone()));
        PhoneFunction.call(new User<IPhone>(new IPhone()));
        PhoneFunction.call(new User<Galaxy>(new Galaxy()));
        PhoneFunction.call(new User<IPhone12Pro>(new IPhone12Pro()));
        PhoneFunction.call(new User<IPhoneX5>(new IPhoneX5()));
        PhoneFunction.call(new User<S22>(new S22()));
        PhoneFunction.call(new User<ZFlip3>(new ZFlip3()));
        System.out.println("\n######################################\n");

//        PhoneFunction.faceId(new User<Phone>(new Phone())); // X
        PhoneFunction.faceId(new User<IPhone>(new IPhone()));
        PhoneFunction.faceId(new User<IPhone12Pro>(new IPhone12Pro()));
        PhoneFunction.faceId(new User<IPhoneX5>(new IPhoneX5()));
//        PhoneFunction.faceId(new User<Galaxy>(new Galaxy())); // X
//        PhoneFunction.faceId(new User<S22>(new S22())); // X
//        PhoneFunction.faceId(new User<ZFlip3>(new ZFlip3())); // X

        System.out.println("\n######################################\n");

//        PhoneFunction.samsungPay(new User<Phone>(new Phone())); // X
//        PhoneFunction.samsungPay(new User<IPhone>(new IPhone())); // X
//        PhoneFunction.samsungPay(new User<IPhone12Pro>(new IPhone12Pro())); // X
//        PhoneFunction.samsungPay(new User<IPhoneX5>(new IPhoneX5())); // X
        PhoneFunction.samsungPay(new User<Galaxy>(new Galaxy()));
        PhoneFunction.samsungPay(new User<S22>(new S22()));
        PhoneFunction.samsungPay(new User<ZFlip3>(new ZFlip3()));

        System.out.println("\n######################################\n");

        PhoneFunction.recordVoice(new User<Phone>(new Phone()));
//        PhoneFunction.recordVoice(new User<IPhone>(new IPhone())); // X
//        PhoneFunction.recordVoice(new User<IPhone12Pro>(new IPhone12Pro())); // X
//        PhoneFunction.recordVoice(new User<IPhoneX5>(new IPhoneX5())); // X
        PhoneFunction.recordVoice(new User<Galaxy>(new Galaxy()));
//        PhoneFunction.recordVoice(new User<S22>(new S22())); // X
//        PhoneFunction.recordVoice(new User<ZFlip3>(new ZFlip3())); // X
    }
}
