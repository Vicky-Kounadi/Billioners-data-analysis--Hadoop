import plotly.graph_objects as go
import pandas as pd
import plotly.express as px

df = pd.read_csv("Q4.txt", sep = '\t', header = None, names = ["category", "percentage", "millionaires", "finalWorth", "averageWealth", "strongestRepresentative"])

# Create Scatter Plot
fig = go.Figure(data = go.Scatter(x = df['percentage'], y = df['millionaires'], mode = 'markers', marker_color = df['finalWorth'], text = df['category'])) # hover text goes here

fig.update_layout(
    xaxis_title="Percentage of Total Wealth",
    yaxis_title="Amount of Millionaires",
)

fig.show()
