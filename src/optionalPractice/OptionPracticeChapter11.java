package optionalPractice;

import java.util.Optional;
import java.util.Properties;
import javaPracticeChapter5.OptionalUtility;

/*
    java实战11-2测验: 对Optional对象进行过滤
    java实战11-3测验: 使用option从属性中读取duration
 */
public class OptionPracticeChapter11 {
    public static void main(String[] args) {
        Insurance insuranceCambridge = new Insurance("Cambridge");
        Insurance insuranceLego = new Insurance("Lego");
        Car benz = new Car(Optional.of(insuranceCambridge));
        Car audi = new Car(Optional.of(insuranceLego));
        Person person1 = new Person(Optional.of(benz), 15);
        Person person2 = new Person(Optional.of(audi), 13);

        //11-2
        System.out.println(getCarInsuranceName(Optional.of(person1), 14));
        System.out.println(getCarInsuranceName(Optional.of(person2), 14));

    }

    // 11-2
    public static String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person
                .filter(it -> it.getAge() > minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    // 11-3
    public int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

}
