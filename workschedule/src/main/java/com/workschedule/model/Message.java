package com.workschedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Message {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "message_id"
    )
    private long message_id;
    private String message_content;
    private Date created_At;
    private Date updated_At;
    @OneToMany(
            mappedBy = "message"
    )
    private List<Attachment> attachmentList;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "conversation_id",
            referencedColumnName = "conversation_id"
    )
    private Conversation conversation;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "participant_id",
            referencedColumnName = "participant_id"
    )
    private Participant participant;
}
