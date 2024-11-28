import matplotlib.pyplot as plt
import pandas as pd

data = pd.read_csv('Q4.txt', delimiter='\t', header=None)

df = pd.DataFrame(data)

X = list(df.iloc[:, 0])
Y = list(df.iloc[:, 1])

#   Create Bar Chart
plt.bar(X, Y, color='g', width=0.8)
plt.xlabel('Category')
plt.ylabel('Percentage')
plt.title('Income percentage based on category')
plt.xticks(rotation=30, ha='right')
plt.show()
