import React from "react";
import "./TextComponent.css";

const STATUS_OK = 200;
const TEST_URL = "http://localhost:8080/";

export class TextComponent extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      title: "",
      text: ""
    };

    this.fetchAndProcessData = this.fetchAndProcessData.bind(this);
  }

  componentDidMount() {
    this.fetchAndProcessData(TEST_URL, "GET");
  }

  /**
   * This method is used as a helper for every other method when they are called.
   * @param {url} url has respective URLs for each step of the game.
   * @param {body} body has the requested parameters by the POST for particular methods.
   * @param successCallback is invoked when success response
   * @param errorCallback is invoked when error response
   */
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
          "Content-type": "application/json; charset=UTF-8"
        }
      });
      if (response.status !== STATUS_OK) {
        throw response;
      }
      response = await response.json();
      this.setState({
        title: response.title,
        text: response.text
      });
    } catch (error) {
      //return error.status;
    }
  }

  render() {
    return <p>{this.state.title}</p>;
  }
}
