let commentSection = document.getElementById('commentSection');

fetch(`http://localhost:8080/api/comments`)
    .then((response) => response.json())
    .then((body) => {
            for (comment of body) {

                //format the date
                let commentDate = new Date(comment.createTime);
                let formattedCommentDate = commentDate.toLocaleString('en-US', {
                    year: 'numeric',
                    month: '2-digit',
                    day: '2-digit',
                    hour: '2-digit',
                    minute: '2-digit',
                    hour12: false
                }).replace(/(\d+)\/(\d+)\/(\d+), (\d+):(\d+) (AM|PM)/, '$3.$2.$1 $4:$5');

                let commentHtml = '<div>\n'
                commentHtml += '<h2>' + comment.authorName + '</h2>\n'
                commentHtml += '<p>' + comment.text + '</p>\n'
                commentHtml += '<span>' + formattedCommentDate + '</span>\n'
                commentHtml += '<hr/>'
                commentHtml += '</div>\n'

                commentSection.innerHTML += commentHtml;
            }
        }
    )