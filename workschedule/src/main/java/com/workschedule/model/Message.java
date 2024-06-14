package com.workschedule.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "message"
)
@ToString
@Builder
public class Message {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "message_id"
    )
    private long message_id;
    private String senderName;
    private String message;
    private String receiverName;
    private String date;

    private MessageType type;
    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    @OneToMany(
            mappedBy = "message"
    )
    private List<Attachment> attachmentList;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user_project_id",
            referencedColumnName = "user_project_id"
    )
    private User_Project userProject;


    @Transient // Đánh dấu thuộc tính này không được lưu trong database
    private Long userId; // Thêm thuộc tính userId

//    @ManyToOne(
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(
//            name = "user_id",
//            referencedColumnName = "user_id"
//    )
//    private Users users;



//    @ManyToOne(
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(
//            name = "conversation_id",
//            referencedColumnName = "conversation_id"
//    )
//    private Conversation conversation;
//    @ManyToOne(
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(
//            name = "participant_id",
//            referencedColumnName = "participant_id"
//    )
//    private Participant participant;
}
