package com.optional_usage;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class OptionalCase {


    public static void main(String[] args) {
        Student student = new Student("Bob", 18,
                new Street("Main Street", new City("Los Angeles", new State("CA"))));

        System.out.println(getStateFromJava7(student));
        System.out.println(getStateFromJava8(student));
    }

    private static String getStateFromJava7(Student student) {
        // Java 7
        if (student != null) {
            Street street = student.getAddress();
            if (street != null) {
                City city = street.getCity();
                if (city != null) {
                    State state = city.getState();
                    if (state != null) {
                        String stateName = state.getName();
                        if (stateName != null) {
                            return stateName;
                        }
                        return "unknown";
                    }
                    return "unknown";
                }
                return "unknown";
            }
            return "unknown";
        }
        return "unknown";
    }

    private static String getStateFromJava8(Student student) {
        Optional<Student> studentOpt = Optional.ofNullable(student);
        // Java 8
        return studentOpt
                .map(Student::getAddress)
                .map(Street::getCity)
                .map(City::getState)
                .map(State::getName)
                .orElse("unknown");
    }

    @Getter
    @AllArgsConstructor
    static class Student {

		public Student(String name, Integer age, Street address) {
			super();
			this.name = name;
			this.age = age;
			this.address = address;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public Street getAddress() {
			return address;
		}
		public void setAddress(Street address) {
			this.address = address;
		}
		private String name;
        private Integer age;
        private Street address;
    }

    @Getter
    @AllArgsConstructor
    static class Street {

		public Street(String name, City city) {
			super();
			this.name = name;
			this.city = city;
		}
		public City getCity() {
			return city;
		}
		public void setCity(City city) {
			this.city = city;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		private String name;
        private City city;
    }

    @Getter
    @AllArgsConstructor
    static class City {
    	
        public City(String name, State state) {
			super();
			this.name = name;
			this.state = state;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
		private String name;
        private State state;
    }

    @Getter
    @AllArgsConstructor
    static class State {


		public State(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private String name;
    }
}