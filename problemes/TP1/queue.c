#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int val;
    struct Node *next;
} Node;

typedef struct {
    Node *front, *back;
} Queue;

int is_empty(Queue *q) {
    return q->front == NULL;
}

void enqueue(Queue *q, int val) {
    Node *n = malloc(sizeof(Node));
    n->val = val;
    n->next = NULL;
    if (q->back) q->back->next = n;
    else q->front = n;
    q->back = n;
}

int dequeue(Queue *q) {
    Node *n = q->front;
    int val = n->val;
    q->front = n->next;
    if (!q->front) q->back = NULL;
    free(n);
    return val;
}

void invert_queue(Queue *q) {
    if (is_empty(q)) return;
    int val = dequeue(q);
    invert_queue(q);
    enqueue(q, val);
}

int main(void) {
    Queue q = {NULL, NULL};
    for (int i = 1; i <= 5; i++) enqueue(&q, i);

    invert_queue(&q);

    while (!is_empty(&q)) printf("%d ", dequeue(&q));
    printf("\n");
    return 0;
}