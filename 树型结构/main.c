#include <stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<string.h>
#define m 3
#define MAXLEN 100
typedef char datatype;
typedef struct node{
  datatype data;
  struct node *child[m];

  }node;
  typedef node *tree;
  tree createtree()
  {
      int i;
      char ch;
      tree t;
      if ((ch=getchar())=='#')
        t=NULL;
      else
      {
          t=(tree)malloc(sizeof(node));
          t->data=ch;

          for (i=0;i<m;i++)
            t->child[i]=createtree();
      }
      return t;
}
void levelorder(tree t)
{
    tree queue[100];
    int f,r,i;
    tree p;
    f=0;
    r=1;
    queue[0]=t;
    while(f<r)
    {
        p=queue[f];
        f++;
        printf("%c",p->data);
        for(i=0;i<m;++i)
        {
            queue[r]=p->child[i];
            ++r;
        }
    }

}
int main()
{
    tree t;
    printf("Ç°Ðò±éÀú:\n");
    t=createtree();
    printf("the levelorder is");
    levelorder(t);
    return 0;

}

