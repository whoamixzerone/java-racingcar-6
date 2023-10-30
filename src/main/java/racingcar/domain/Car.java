package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private Map<String, Integer> cars;
    private final int NAME_SIZE = 5;
    private final int FOWARD_NUMBER = 4;

    public Car() {
    }

    public Car(String inputName) {
        cars = initToMap(validateNameLength(splitNames(inputName)));
    }

    private Map<String, Integer> initToMap(String[] names) {
        Map<String, Integer> cars = new HashMap<>();
        for (String name : names) {
            cars.put(name, 0);
        }
        return cars;
    }

    private String[] splitNames(String inputName) {
        return inputName.split(",");
    }

    private String[] validateNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > NAME_SIZE) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.");
            }
        }
        return names;
    }

    public void forward(Map.Entry<String, Integer> entry, int randomNumber) {
        if (!isForward(randomNumber)) {
            return;
        }
        int step = entry.getValue() + 1;
        cars.put(entry.getKey(), step);
    }

    public boolean isForward(int randomNumber) {
        return randomNumber >= FOWARD_NUMBER;
    }

    public Map<String, Integer> getCars() {
        return cars;
    }
}
