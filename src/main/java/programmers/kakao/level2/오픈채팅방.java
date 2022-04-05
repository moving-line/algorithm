package programmers.kakao.level2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

// 2019 카카오 블라인드 채용
public class 오픈채팅방 {
    // 빨리빨리 첫풀이
    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        List<User> chat = new ArrayList<>();

        for (String str : record) {
            String[] input = str.split(" ");

            switch (input[0]) {
                case "Enter":
                    users.put(input[1], input[2]);
                    chat.add(new User(input[1], input[2], Status.ENTER));
                    break;
                case "Change":
                    users.put(input[1], input[2]);
                    break;
                case "Leave":
                    chat.add(new User(input[1], Status.LEAVE));
                    break;
            }
        }

        for (User user : chat) {
            user.nickname = users.get(user.getId());
        }

        return chat.stream()
                .map(i -> i.getNickname() + "님이 " + i.status.getComment() + "습니다.")
                .toArray(String[]::new);
    }

    class User {
        private String id;
        private String nickname;
        private Status status;

        public User(String id, String nickname, Status status) {
            this.id = id;
            this.nickname = nickname;
            this.status = status;
        }

        public User(String id, Status status) {
            this.id = id;
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public String getNickname() {
            return nickname;
        }
    }

    enum Status {
        ENTER(1, "들어왔"),
        LEAVE(2, "나갔"),
        CHANGE(3, "변경했");

        private final int i;
        private final String comment;

        Status(int i, String comment) {
            this.i = i;
            this.comment = comment;
        }

        public String getComment() {
            return comment;
        }
    }

    // 유저객체/닉네임변경로직/비즈니스와뷰단결합 을 제거한 리팩토링
//    private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
//    private static final String LEAVE_MESSAGE = "님이 나갔습니다.";
//
//    private Map<String, String> users = new HashMap<>();
//    private List<Command> commands = new ArrayList<>();
//
//    public String[] solution(String[] record) {
//        for (String log : record) {
//            createCommand(log);
//        }
//        return commands.stream()
//                .map(this::createMessage)
//                .toArray(String[]::new);
//    }
//
//    private void createCommand(String log) {
//        String[] logInfo = log.split(" ");
//        String cmd = logInfo[0];
//        String id = logInfo[1];
//        String nickname = logInfo.length > 2 ? logInfo[2] : null;
//
//        switch (cmd) {
//            case "Enter":
//                users.put(id, nickname);
//                commands.add(new Command(id, Status.ENTER));
//                break;
//            case "Change":
//                users.put(id, nickname);
//                break;
//            case "Leave":
//                commands.add(new Command(id, Status.LEAVE));
//                break;
//        }
//    }
//
//    private String createMessage(Command cmd) {
//        String id = users.get(cmd.userId);
//        String suffix = cmd.status.equals(Status.ENTER) ? ENTER_MESSAGE : LEAVE_MESSAGE;
//
//        return id + suffix;
//    }
//
//    class Command {
//        private final String userId;
//        private final Status status;
//
//        public Command(String userId, Status status) {
//            this.userId = userId;
//            this.status = status;
//        }
//    }
//
//    enum Status {
//        ENTER, LEAVE, CHANGE
//    }

    @Test
    void test() {
        assertThat(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}))
                .isEqualTo(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});
    }
}
