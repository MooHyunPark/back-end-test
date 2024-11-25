package co.kr.metacoding.backendtest.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UserRequest {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SaveUserDTO {
        @NotBlank
        private String name;

        public User toEntity(String name) {
            return new User(name);
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateUserDTO {
        @NotBlank
        private String name;

        public User toEntity(String name) {
            return new User(name);
        }
    }
}
