import React from "react";
import "./Submission-Preview.css";

export class SubmissionPreview extends React.Component {
    render() {
        return (
            <div className="submissionPreview">
                <a href={"/submission/" + this.props.id}>
                    <div className="submissionPreviewTitle">
                        {this.props.title}
                    </div>
                    <div className="submissionPreviewText">
                        {this.props.text}
                    </div>
                    <div className="submissionPreviewUserInfo">
                        Submitted by {this.props.user.name} on{" "}
                        {new Intl.DateTimeFormat("en-US").format(
                            new Date(this.props.submitted)
                        )}{" "}
                        at{" "}
                        {new Intl.DateTimeFormat("en-US", {
                            hour: "2-digit",
                            minute: "2-digit",
                            second: "2-digit",
                        }).format(new Date(this.props.submitted))}
                    </div>
                </a>
            </div>
        );
    }
}
