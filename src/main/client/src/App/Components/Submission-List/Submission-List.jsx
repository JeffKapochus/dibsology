import React from "react";
import "./Submission-List.css";
import * as Constants from "../../Utils/Constants";

import { SubmissionPreview } from "../Submission-Preview/Submission-Preview";

export class SubmissionList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            submissions: [],
        };

        this.fetchAndProcessData = this.fetchAndProcessData.bind(this);
    }
    componentDidMount() {
        this.fetchAndProcessData(
            Constants.APP_URL + Constants.SUBMISSION_LIST_URL,
            Constants.HTTP_GET
        );
    }

    async fetchAndProcessData(
        url,
        type,
        body,
        successCallback = () => {},
        errorCallback = () => {}
    ) {
        try {
            let response = await fetch(url, {
                method: type,
                body: body,
                headers: {
                    "Content-type": "application/json; charset=UTF-8",
                },
            });
            if (response.status !== Constants.STATUS_OK) {
                throw response;
            }
            response = await response.json();
            this.setState({
                submissions: response,
            });
        } catch (error) {
            return error.status;
        }
    }

    render() {
        return (
            <div className="submissionListDiv">
                <ul>
                    {this.state.submissions.map(submission => {
                        return (
                            <li key={"sub-" + submission.id}>
                                <SubmissionPreview
                                    title={submission.title}
                                    text={submission.text}
                                    user={submission.user}
                                    submitted={submission.created_at}
                                    id={submission.id}
                                />
                            </li>
                        );
                    })}
                </ul>
            </div>
        );
    }
}
