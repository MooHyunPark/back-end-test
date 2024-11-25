package co.kr.metacoding.backendtest.user;


import lombok.Data;

public class UserResponse {

    @Data
    public static class SaveUserIdDTO {
        private String id;

        public SaveUserIdDTO(User user) {
            this.id = user.getId();
        }
    }

    @Data
    public static class UserDetailDTO {
        private String id;
        private String name;

        public UserDetailDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }


}
