package co.kr.metacoding.backendtest.user;


import lombok.Data;

public class UserResponse {

    @Data
    public static class SaveUserIdDTO {
        private Integer id;

        public SaveUserIdDTO(User user) {
            this.id = user.getId();
        }
    }

    @Data
    public static class UserDetailDTO {
        private Integer id;
        private String name;

        public UserDetailDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }

    @Data
    public static class UpdateUserDTO {
        private Integer id;
        private String name;

        public UpdateUserDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }


}
