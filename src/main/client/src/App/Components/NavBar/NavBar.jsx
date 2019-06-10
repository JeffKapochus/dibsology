import React from "react";
import "./NavBar.css";

export class NavBar extends React.Component {
    render() {
        return (
            <div id="navBar">
                <ul>
                    <li>
                        <a href="/">Home</a>
                    </li>
                    <li>
                        <a href="/submissions">Submissions</a>
                    </li>
                    <li>
                        <a href="/user">Account</a>
                    </li>
                </ul>
            </div>
        );
    }
}
