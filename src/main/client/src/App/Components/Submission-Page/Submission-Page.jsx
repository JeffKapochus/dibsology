import React from "react";

const STATUS_OK = 200;
const submissionUrl = "http://localhost:8080/submission/";
export class SubmissionPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            submission: {},
            user: {},
        };
    }

    componentDidMount() {
        this.fetchAndProcessData(
            submissionUrl + this.props.match.params.id,
            "GET"
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
            if (response.status !== STATUS_OK) {
                throw response;
            }
            response = await response.json();
            this.setState({
                submission: response,
                user: response.user,
            });
        } catch (error) {
            //return error.status;
        }
    }

    render() {
        return (
            <div className="submissionPage">
                <div className="submissionTitle">
                    {this.state.submission.title}
                </div>
                <div className="submissionText">
                    {this.state.submission.text}
                </div>
                <div className="submissionUserInfo">
                    Submitted by {this.state.user.name} on{" "}
                    {new Date(
                        this.state.submission.created_at
                    ).toLocaleDateString()}{" "}
                    at{" "}
                    {new Date(
                        this.state.submission.created_at
                    ).toLocaleTimeString()}
                </div>
            </div>
        );
    }
}
