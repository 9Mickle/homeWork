package Zoo.ComponentsZoo;

import Zoo.ComponentsZoo.Animal;
import Zoo.ComponentsZoo.Employee;
import Zoo.ComponentsZoo.Enclosure;

import java.util.Arrays;

/**
 * Зоопарк
 */
public class Zoo {

    Animal[] animals = new Animal[] {}; //Животные
    Employee[] employees = new Employee[] {}; //Сотрудники
    Enclosure[] enclosures = new Enclosure[] {}; //Вольеры

    /**
     * Добавление животного
     */
    public void addAnimal(Animal animal) {
        animals = Arrays.copyOf(animals, animals.length + 1);
        animals[animals.length - 1] = animal;
    }

    /**
     * Добавление сотрудников и вольеров
     */
    public void addStaff(Employee employee, Enclosure enclosure) {
        employees = Arrays.copyOf(employees, employees.length + 1);
        employees[employees.length - 1] = employee;

        enclosures = Arrays.copyOf(enclosures, enclosures.length + 1);
        enclosures[enclosures.length - 1] = enclosure;
    }

    /**
     * Удаление животного
     */
    public void remove(Animal animal) {
        final Animal[] newAnimals = new Animal[animals.length - 1];
        int index = 0;

        for (Animal currentAnimal : animals) {
            if (currentAnimal != animal) {
                newAnimals[index++] = currentAnimal;
            }
        }
        animals = newAnimals;
    }

    /**
     * Чистка вольера
     *
     * @param index
     */
    public void clean(int index) {
        if (enclosures[index].isCleanStatus()) {
            System.out.println("\nВольер " + enclosures[index] + " грязный");
            System.out.println("Сотрудник " + employees[index] + " почистил вольер " + enclosures[index]);
            enclosures[index].setCleanStatus(false);
        } else System.out.println("\nВольер " + enclosures[index] + " чистый");
    }

    /**
     * Кормление животного
     *
     * @param index
     */
    public void feed(int index) {
        if (animals[index].isFeedStatus()) {
            System.out.println("\nЖивотное " + animals[index] + " голодное");
            System.out.println("Сотрудник " + employees[index] + " покормил животное " + animals[index]);
            animals[index].setFeedStatus(false);
        } else System.out.println("\nЖивотное " + animals[index] + " покормлено");
    }

    /**
     * Болезнь животного
     *
     * @param index
     */
    public void disease(int index) {
        if (animals[index].isDiseaseStatus()) {
            System.out.println("\nЖивотное " + animals[index] + " заболело и умерло");
        }
    }

    /**
     * Поставить свободного сотрудника в конец списка
     *
     * @param animalIndex
     * @param employee
     * @param enclosure
     */
    public void swapElem(int animalIndex, Employee employee, Enclosure enclosure) {
        Employee[] someString = new Employee[] {}; //Для обмена
        someString =  Arrays.copyOf(employees, employees.length);

        employees[employees.length - 1] = employees[animalIndex];
        someString[animalIndex] = employees[employees.length - 1];
        employees[animalIndex] = someString[employees.length - 1];

        remove(animals[animalIndex]);

    }


    /**
     * Информация о зоопарке
     */
    public void info() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Сотрудник " + employees[i] + " отвечает за животное " + animals[i] +
                    ",которому дан вольер " + enclosures[i]);
        }
    }
}