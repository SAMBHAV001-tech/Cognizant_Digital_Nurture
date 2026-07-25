import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch posts');
        }
        return response.json();
      })
      .then(data => {
        this.setState({ posts: data });
      })
      .catch(error => {
        this.setState({ error: error.message });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    this.setState({ error: error.message });
  }

  render() {
    if (this.state.error) {
      return (
        <div className="error-card">
          <h2>Error occurred</h2>
          <p>{this.state.error}</p>
        </div>
      );
    }

    return (
      <div className="posts-container">
        <h1 className="main-title">Posts Feed</h1>
        <div className="posts-list">
          {this.state.posts.map(post => (
            <Post key={post.id} title={post.title} body={post.body} />
          ))}
        </div>
      </div>
    );
  }
}

export default Posts;
